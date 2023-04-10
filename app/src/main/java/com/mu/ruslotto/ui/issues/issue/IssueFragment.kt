package com.mu.ruslotto.ui.issues.issue

import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mu.ruslotto.databinding.FragmentIssueBinding
import com.mu.ruslotto.utils.dateToString
import com.mu.ruslotto.utils.toRoom
import java.time.LocalDate
import java.util.*


class IssueFragment : Fragment() {
    private lateinit var binding: FragmentIssueBinding
    private val viewModel: IssueViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIssueBinding.inflate(layoutInflater, container, false)

        binding.pbIssue.visibility = View.GONE

        val issue = IssueFragmentArgs.fromBundle(requireArguments()).issue

        //int resourceId = this.getResources().getIdentifier("nameOfResource", "id", this.getPackageName())

        /*val resourceId = resources.getIdentifier("tvIssueDate", "id", APP_ACTIVITY.packageName)
        val tv = binding.root.findViewById<TextView>(resourceId)
        tv.text = "qwerty"*/

        val calendar = initDate(issue.date)
        initViewIssueDate(calendar)
        initDatePicker(calendar)

        observeTickets(issue.id)

        return binding.root
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
            binding.tvIssuesDataAbsent.visibility = View.GONE

        adapterIssues.setIssues(it)*/
    }
}
