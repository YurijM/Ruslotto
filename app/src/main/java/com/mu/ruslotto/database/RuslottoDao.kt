package com.mu.ruslotto.database

import androidx.room.*
import com.mu.ruslotto.models.TicketModel
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

    @Query("SELECT t.ticket, " +
            "k.card, k.row, k.column, k.number, k.did_keg_win " +
            "FROM table_issues i " +
            "INNER JOIN table_tickets t ON t.issue_id = i.id " +
            "INNER JOIN table_kegs k ON k.ticket_id = t.id " +
            "WHERE i.id = :issueId " +
            "ORDER BY t.ticket, k.card, k.row, k.column")
    fun getTickets(issueId: Int): Flow<List<TicketModel>>
}