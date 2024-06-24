package com.mu.ruslotto.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mu.ruslotto.data.entity.KegEntity
import com.mu.ruslotto.domain.model.KegModel
import kotlinx.coroutines.flow.Flow

@Dao
interface KegDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(keg: KegEntity)

    @Delete
    suspend fun delete(keg: KegEntity)

    @Query("SELECT d.id AS drawId, t.id AS ticketId, ticket, k.id AS kegId, k.`row`, k.`column`, keg, win FROM table_draws d " +
            "INNER JOIN table_tickets t ON t.draw_id = d.id " +
            "INNER JOIN table_kegs k ON k.ticket_id = t.id " +
            "WHERE d.id = :drawId")
    fun getKeg(drawId: Int): Flow<List<KegModel>>
}