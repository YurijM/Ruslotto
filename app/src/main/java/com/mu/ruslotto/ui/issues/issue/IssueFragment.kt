package com.mu.ruslotto.ui.issues.issue

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.mu.ruslotto.databinding.FragmentIssueBinding
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class IssueFragment : Fragment(),
    DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener
{
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
        binding.tvIssueDateEdit.text = date.format(DateTimeFormatter.ofPattern("dd.MM.y"))

        initDatePicker(date)

        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initDatePicker(date: LocalDate?) {
        binding.ibIssueDateEdit.setOnClickListener {
            val day = date?.dayOfMonth ?: 2023
            val month = date?.monthValue ?: 1
            val year = date?.year ?: 1

            val datePickerDialog = DatePickerDialog(requireContext(), null, year, month, day)

            datePickerDialog.show()
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val start = "$dayOfMonth.${month + 1}.$year"
        binding.tvIssueDateEdit.text = start
    }


    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
    }
}