package com.mu.ruslotto.ui.issues.issue

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mu.ruslotto.utils.DAO

class IssueViewModel: ViewModel() {
    fun getTickets(idIssue: Int) = liveData {
        DAO.getTickets(idIssue).collect {
            emit(it)
        }
    }
}
