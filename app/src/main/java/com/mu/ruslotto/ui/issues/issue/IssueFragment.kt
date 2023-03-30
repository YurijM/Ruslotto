package com.mu.ruslotto.ui.issues.issue

import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.mu.ruslotto.databinding.FragmentIssueBinding
import com.mu.ruslotto.utils.dateToString
import com.mu.ruslotto.utils.toRoom
import java.time.LocalDate
import java.util.*

class IssueFragment : Fragment() {
    private lateinit var binding: FragmentIssueBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIssueBinding.inflate(layoutInflater, container, false)

        binding.pbIssue.visibility = View.GONE

        val issue = IssueFragmentArgs.fromBundle(requireArguments()).issue

        val date = LocalDate.parse(issue.date)
        //binding.tvIssueDateEdit.text = date.format(DateTimeFormatter.ofPattern("dd.MM.y"))

        val calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Moscow"))
        calendar.set(date.year, date.monthValue - 1, date.dayOfMonth)

        initViewIssueDate(calendar)

        initDatePicker(calendar)

        return binding.root
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
}