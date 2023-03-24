package com.mu.ruslotto.ui.issues

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mu.ruslotto.database.Issue
import com.mu.ruslotto.databinding.FragmentIssuesBinding

class IssuesFragment : Fragment() {
    private lateinit var binding: FragmentIssuesBinding
    private val viewModel: IssuesViewModel by viewModels()
    private val adapterIssues = IssuesAdapter { issue -> onListIssueClick(issue) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIssuesBinding.inflate(layoutInflater, container, false)

        val recyclerViewRating = binding.rvIssuesList
        recyclerViewRating.adapter = adapterIssues

        observeIssues()
        //loadIssues()

        return binding.root
    }

    /*private fun loadIssues() {
        viewModel.getIssues().observe(viewLifecycleOwner, Observer {
            adapterIssues.setIssues(it)
        })
    }*/
    private fun observeIssues() = viewModel.getIssues().observe(viewLifecycleOwner) {
        if (it.isEmpty())
            binding.tvIssuesDataAbsent.visibility = View.VISIBLE
        else
            binding.tvIssuesDataAbsent.visibility = View.GONE

        adapterIssues.setIssues(it)
    }

    private fun onListIssueClick(issue: Issue) {
        //findNavController().navigate(R.id.action_issuesFragment_to_issueFragment)
        findNavController().navigate(IssuesFragmentDirections.actionIssuesFragmentToIssueFragment(issue))
        //AdminEmailsFragmentDirections.actionAdminEmailsFragmentToAdminEmailFragment(EmailModel())
    }
}