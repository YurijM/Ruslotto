package com.mu.ruslotto.ui.issues.issue

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.mu.ruslotto.database.Keg
import com.mu.ruslotto.utils.DAO
import com.mu.ruslotto.utils.REPOSITORY
import kotlinx.coroutines.launch

class IssueViewModel: ViewModel() {
    fun getTickets(issueId: Int) = liveData {
        DAO.getTickets(issueId).collect {
            emit(it)
        }
    }

    fun getIssueKegs(issueId: Int) = liveData {
        DAO.getIssueKegs(issueId).collect {
            emit(it)
        }
    }

    fun saveKeg(keg: Keg) {
        if (keg.id == 0) {
            addKeg(keg)
        } else if (keg.number == 0) {
            deleteKeg(keg)
        } else {
            editKeg(keg)
        }
    }

    private fun addKeg(keg: Keg) = viewModelScope.launch {
        REPOSITORY.addKeg(keg)
    }

    private fun editKeg(keg: Keg) = viewModelScope.launch {
        REPOSITORY.editKeg(keg)
    }

    private fun deleteKeg(keg: Keg) = viewModelScope.launch {
        REPOSITORY.deleteKeg(keg)
    }
}
