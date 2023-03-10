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
}