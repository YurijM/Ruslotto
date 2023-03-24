package com.mu.ruslotto.ui.issues

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.mu.ruslotto.databinding.FragmentIssueBinding
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class IssueFragment : Fragment() {
    private lateinit var binding: FragmentIssueBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIssueBinding.inflate(layoutInflater, container, false)

        val issue = IssueFragmentArgs.fromBundle(requireArguments()).issue

        val date = LocalDate.parse(issue.date)
        binding.tvIssueDateEdit.text = date.format(DateTimeFormatter.ofPattern("dd.MM.y"))

        return binding.root
    }
}