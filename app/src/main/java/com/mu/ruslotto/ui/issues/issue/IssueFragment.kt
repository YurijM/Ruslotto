package com.mu.ruslotto.ui.issues.issue

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mu.ruslotto.database.Keg
import com.mu.ruslotto.database.Ticket
import com.mu.ruslotto.databinding.FragmentIssueBinding
import com.mu.ruslotto.utils.COLS_COUNT
import com.mu.ruslotto.utils.ROWS_COUNT
import com.mu.ruslotto.utils.dateToString
import com.mu.ruslotto.utils.toRoom
import java.time.LocalDate
import java.util.*

class IssueFragment : Fragment() {
    private lateinit var binding: FragmentIssueBinding
    private val viewModel: IssueViewModel by viewModels()
    private val adapterIssue = IssueAdapter { issue -> onCellClick(issue) }
    private lateinit var tickets: List<Ticket>

    private lateinit var dialog: AlertDialog

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

        dialog = AlertDialog.Builder(requireContext())
            .setCancelable(false)
            .setNegativeButton("Cancel") { dialog, _ ->
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

    private fun onCellClick(keg: Keg) {
        /*val dialog = AlertDialog.Builder(APP_ACTIVITY)
            .setCancelable(false)
            .setTitle(keg.toString())
            .setNegativeButton("Cancel") {dialog, _ ->
                dialog.dismiss()
            }
            .create()*/

        dialog.setTitle(keg.toString())
        dialog.show()
        //showToast(keg.toString())
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
        val issueKegs = mutableListOf<Keg>()

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
