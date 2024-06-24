package com.mu.ruslotto.domain.repository

import com.mu.ruslotto.data.entity.DrawEntity
import kotlinx.coroutines.flow.Flow

interface DrawRepository {
    suspend fun update(draw: DrawEntity)
    suspend fun delete(draw: DrawEntity)
    suspend fun deleteDraw(draw: DrawEntity, ticketId1: Int, ticketId2: Int) {
        deleteKeg(ticketId1)
        deleteKeg(ticketId2)
        deleteTicket(draw.id)
    }
    suspend fun deleteTicket(drawId: Int)
    suspend fun deleteKeg(ticketId: Int)
    fun listDraw(): Flow<List<DrawEntity>>
}