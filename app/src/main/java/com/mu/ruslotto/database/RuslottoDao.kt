package com.mu.ruslotto.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface RuslottoDao {
    @Query("SELECT * FROM table_issues")
    fun getIssues(): Flow<List<Issue>>

    @Query("SELECT * FROM table_numbers")
    fun getTicket(): Flow<List<Number>>

    @Insert
    suspend fun addIssue(issue: Issue): Long

    @Update
    suspend fun editIssue(issue: Issue): Int

    @Delete
    suspend fun delIssue(issue: Issue): Int
}