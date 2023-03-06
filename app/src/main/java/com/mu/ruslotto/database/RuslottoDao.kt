package com.mu.ruslotto.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RuslottoDao {
    @Query("SELECT * FROM table_issues")
    fun getIssues(): LiveData<List<Issue>>

    @Insert
    suspend fun addIssue(issue: Issue): Long

    @Update
    suspend fun editIssue(issue: Issue): Int

    @Delete
    suspend fun delIssue(issue: Issue): Int
}