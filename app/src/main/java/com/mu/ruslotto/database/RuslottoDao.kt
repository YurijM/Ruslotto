package com.mu.ruslotto.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface RuslottoDao {
    @Query("SELECT * FROM table_issues")
    fun getIssues(): Flow<List<Issue>>

    /*@Insert
    suspend fun addIssue(issue: Issue): Long

    @Update
    suspend fun editIssue(issue: Issue): Int

    @Delete
    suspend fun delIssue(issue: Issue): Int*/

    @Query("SELECT * FROM table_tickets WHERE issue_id = :issueId")
    fun getTickets(issueId: Int): Flow<List<Ticket>>

    @Query("SELECT k.id, k.card, k.row, k.column, k.number, k.did_keg_win, k.ticket_id " +
            "FROM table_issues i " +
            "INNER JOIN table_tickets t ON t.issue_id = i.id " +
            "INNER JOIN table_kegs k ON k.ticket_id = t.id " +
            "WHERE i.id = :issueId " +
            "ORDER BY t.id, k.card, k.row, k.column")
    fun getIssueKegs(issueId: Int): Flow<List<Keg>>
}