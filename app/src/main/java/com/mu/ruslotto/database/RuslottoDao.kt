package com.mu.ruslotto.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface RuslottoDao {
    @Query("SELECT * FROM table_issues")
    fun getIssues(): Flow<List<Issue>>

    @Insert
    suspend fun addIssue(issue: Issue): Long

    @Update
    suspend fun editIssue(issue: Issue): Int

    @Delete
    suspend fun delIssue(issue: Issue): Int

    @Query("SELECT * FROM table_numbers WHERE ticket_id = :id ORDER BY card, row, column")
    fun getTicket(id: Int): Flow<List<Number>>

    @Insert
    suspend fun addTicket(ticket: Ticket): Long

    @Update
    suspend fun editTicket(ticket: Ticket): Int

    @Delete
    suspend fun delTicket(ticket: Ticket): Int
}