package com.mu.ruslotto.ui.issues.issue

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mu.ruslotto.utils.DAO

class IssueViewModel_(private val idIssue: Int) : ViewModel() {
    init {
        loadData()
    }

    private fun loadData() = liveData {
        DAO.getTickets(idIssue).collect {
            emit(it)
        }
    }
}
