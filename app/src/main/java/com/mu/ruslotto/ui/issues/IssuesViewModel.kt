package com.mu.ruslotto.ui.issues

import androidx.lifecycle.ViewModel
import com.mu.ruslotto.database.Issue
import com.mu.ruslotto.utils.DAO
import kotlinx.coroutines.flow.Flow

class IssuesViewModel : ViewModel() {
    fun getIssues(): Flow<List<Issue>> = DAO.getIssues()
}