package com.mu.ruslotto.ui.issues

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mu.ruslotto.utils.REPOSITORY

class IssuesViewModel : ViewModel() {
    //fun getIssues(): Flow<List<Issue>> = DAO.getIssues()

    fun getIssues() = liveData {
        REPOSITORY.issues.collect {
            emit(it)
        }
    }
}