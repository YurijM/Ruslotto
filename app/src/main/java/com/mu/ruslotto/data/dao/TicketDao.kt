package com.mu.ruslotto.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mu.ruslotto.data.entity.TicketEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TicketDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(ticket: TicketEntity)

    @Query ("SELECT id, draw_id, ticket FROM table_tickets " +
            "WHERE draw_id = :drawId")
    fun listTickets(drawId: Int) : Flow<List<TicketEntity>>
}