package com.mu.ruslotto.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.mu.ruslotto.data.entity.DrawEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DrawDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(draw: DrawEntity)

    @Delete
    suspend fun delete(draw: DrawEntity)

    @Transaction
    suspend fun deleteDraw(draw: DrawEntity, ticketId1: Int, ticketId2: Int) {
        deleteKeg(ticketId1)
        deleteKeg(ticketId2)
        deleteTicket(draw.id)
    }

    @Query("DELETE FROM table_tickets WHERE draw_id = :drawId")
    suspend fun deleteTicket(drawId: Int)

    @Query("DELETE FROM table_kegs WHERE ticket_id = :ticketId")
    suspend fun deleteKeg(ticketId: Int)

    @Query("SELECT * FROM table_draws " +
            "ORDER BY date DESC")
    fun listDraw(): Flow<List<DrawEntity>>
}