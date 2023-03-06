package com.mu.ruslotto.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RuslottoDao {
    @Query("SELECT * FROM table_issues")
    fun getIssues(): LiveData<List<Issue>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addIssue(issue: Issue)

    @Delete
    suspend fun delIssue(issue: Issue)
}