package com.mu.ruslotto.ui.issues.issue

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.Html.FROM_HTML_MODE_LEGACY
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mu.ruslotto.R
import com.mu.ruslotto.database.Keg
import com.mu.ruslotto.database.Ticket
import com.mu.ruslotto.databinding.FragmentIssueBinding
import com.mu.ruslotto.utils.APP_ACTIVITY
import com.mu.ruslotto.utils.COLS_COUNT
import com.mu.ruslotto.utils.ROWS_COUNT
import com.mu.ruslotto.utils.dateToString
import com.mu.ruslotto.utils.showToast
import com.mu.ruslotto.utils.toLog
import com.mu.ruslotto.utils.toRoom
import java.time.LocalDate
import java.util.*
import kotlin.math.floor


class IssueFragment : Fragment() {
    private lateinit var binding: FragmentIssueBinding
    private val viewModel: IssueViewModel by viewModels()
    private val adapterIssue = IssueAdapter { keg -> onCellClick(keg) }
    private lateinit var tickets: List<Ticket>
    private lateinit var issueKegs: MutableList<Keg>

    private lateinit var dialog: AlertDialog
    //private lateinit var layoutItemKeyNumber: View
    private lateinit var etKeyNumber: EditText
    private lateinit var currentKeg: Keg

    @SuppressLint("InflateParams")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIssueBinding.inflate(layoutInflater, container, false)

        //binding.pbIssue.visibility = View.GONE

        val issue = IssueFragmentArgs.fromBundle(requireArguments()).issue

        //int resourceId = this.getResources().getIdentifier("nameOfResource", "id", this.getPackageName())

        /*val resourceId = resources.getIdentifier("tvIssueDate", "id", APP_ACTIVITY.packageName)
        val tv = binding.root.findViewById<TextView>(resourceId)
        tv.text = "qwerty"*/

        val layoutItemKeyNumber = LayoutInflater.from(requireContext()).inflate(R.layout.item_keg_number, null)
        etKeyNumber = layoutItemKeyNumber.findViewById(R.id.etItemKeyNumber)

        //dialog = AlertDialog.Builder(requireContext())
        dialog = AlertDialog.Builder(APP_ACTIVITY)
            //.setTitle("Введите число")
            .setTitle(Html.fromHtml("<font color='#0000FF'>Введите число</font>", FROM_HTML_MODE_LEGACY))
            .setCancelable(false)
            .setView(layoutItemKeyNumber)
            .setPositiveButton(R.string.input) { _, _ ->
                val kegNumber = etKeyNumber.text.toString()
                if (checkKeg(kegNumber, currentKeg)) {
                    currentKeg.number = if (kegNumber.isBlank()) 0 else kegNumber.toInt()
                    val cardKegsCount = issueKegs.filter { keg -> keg.number > 0 && keg.ticket_id == currentKeg.ticket_id && keg.card == currentKeg.card }.size

                    if ((currentKeg.id == 0 && cardKegsCount <= 15)
                        || (currentKeg.id > 0)) {
                        viewModel.saveKeg(currentKeg)
                    } else {
                        currentKeg.id = 0
                        currentKeg.number = 0
                        showToast("Уже 15")
                    }
                } else {
                    val error = APP_ACTIVITY.getString(R.string.incorrect_number, kegNumber)
                    showToast(error)
                }
            }
            .setNegativeButton(R.string.cancel) { dialog, _ ->
                dialog.dismiss()
            }
            .create()

        val calendar = initDate(issue.date)
        initViewIssueDate(calendar)
        initDatePicker(calendar)

        val recyclerViewTickets = binding.rvIssueTicketsList
        recyclerViewTickets.adapter = adapterIssue

        observeTickets(issue.id)
        //observeIssueKegs(issue.id)

        return binding.root
    }

    @SuppressLint("ResourceAsColor")
    private fun onCellClick(keg: Keg) {
        toLog("keg: $keg")

        currentKeg = keg
        etKeyNumber.setText(if (keg.number == 0) "" else keg.number.toString())

        //dialog.setMessage(keg.toString())
        //dialog.setMessage(keg.toString())

        dialog.show()

        dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(R.color.black)
        dialog.getButton(DialogInterface.BUTTON_NEGATIVE).isAllCaps = false

        //dialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(R.color.white)
        dialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(0xFF0000FF.toInt())
        dialog.getButton(DialogInterface.BUTTON_POSITIVE).isAllCaps = false

        //showToast(keg.toString())
    }

    private fun checkKeg(number: String, keg: Keg): Boolean {
        return number.isBlank()
                || floor(number.toDouble() / 10).toInt() == keg.column
                || (number.toInt() == 90 && keg.column == 8)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initDate(date: String): Calendar {
        val localDate = if (date.isNotEmpty())
            LocalDate.parse(date)
        else
            LocalDate.now(TimeZone.getTimeZone("Europe/Moscow").toZoneId())

        val calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Moscow"))
        calendar.set(localDate.year, localDate.monthValue - 1, localDate.dayOfMonth)

        return calendar
    }

    private fun initViewIssueDate(calendar: Calendar) {
        binding.tvIssueDateEdit.text = calendar.dateToString()
        binding.tvIssueDateEdit.tag = calendar.toRoom()
    }

    private fun initDatePicker(calendar: Calendar) {
        // create an OnDateSetListener
        val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, monthOfYear)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            initViewIssueDate(calendar)
        }

        // when you click on the button, show DatePickerDialog that is set with OnDateSetListener
        binding.ibIssueDateEdit.setOnClickListener {
            DatePickerDialog(
                requireContext(),
                dateSetListener,
                // set DatePickerDialog to point to today's date when it loads up
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    private fun observeTickets(issueId: Int) = viewModel.getTickets(issueId).observe(viewLifecycleOwner) {
        /*if (it.isEmpty())
            binding.tvIssuesDataAbsent.visibility = View.VISIBLE
        else
            binding.tvIssuesDataAbsent.visibility = View.GONE*/

        tickets = it
        adapterIssue.setTickets(it)

        observeIssueKegs(issueId)
    }

    private fun observeIssueKegs(issueId: Int) = viewModel.getIssueKegs(issueId).observe(viewLifecycleOwner) { kegs ->
        //val issueKegs = mutableListOf<Keg>()
        issueKegs = mutableListOf()

        tickets.forEach { ticket ->
            (1..2).forEach { card ->
                (0 until ROWS_COUNT).forEach { row ->
                    (0 until COLS_COUNT).forEach { col ->
                        val ticketKegs = kegs.filter { it.ticket_id == ticket.id && it.card == card }

                        val keg = ticketKegs.find { keg -> keg.card == card && keg.row == row && keg.column == col }

                        if (keg != null) {
                            issueKegs.add(keg)
                        } else {
                            issueKegs.add(Keg(0, card, row, col, 0, false, ticket.id))
                        }
                    }
                }
            }
        }

        adapterIssue.setKegs(issueKegs)
    }
}
