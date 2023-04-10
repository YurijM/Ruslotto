package com.mu.ruslotto.ui.issues.issue

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mu.ruslotto.utils.DAO

class IssueViewModel: ViewModel() {
    fun getTickets(issueId: Int) = liveData {
        DAO.getTickets(issueId).collect {
            emit(it)
        }
    }

    fun getTicket(issueId: Int, ticketId: Int) = liveData {
        DAO.getTicket(issueId, ticketId).collect {
            emit(it)
        }
    }
}
