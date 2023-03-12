package com.mu.ruslotto.ui.issues

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mu.ruslotto.R
import com.mu.ruslotto.database.Issue
import com.mu.ruslotto.databinding.FragmentIssuesBinding
import androidx.navigation.fragment.findNavController

class IssuesFragment : Fragment() {
    private lateinit var binding: FragmentIssuesBinding

    //private val viewModel: RatingViewModel by viewModels()
    private val adapterIssues = IssuesAdapter { issue -> onListItemClick(issue) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIssuesBinding.inflate(layoutInflater, container, false)

        val recyclerViewRating = binding.rvIssuesList
        recyclerViewRating.adapter = adapterIssues

        //observeGamblers()

        return binding.root
    }

    private fun onListItemClick(issue: Issue) {
        findNavController().navigate(R.id.action_splashFragment_to_main_graph)
    }
}