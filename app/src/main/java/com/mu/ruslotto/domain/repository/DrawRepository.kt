package com.mu.ruslotto.domain.repository

import com.mu.ruslotto.data.entity.DrawEntity
import kotlinx.coroutines.flow.Flow

interface DrawRepository {
    suspend fun update(draw: DrawEntity)
    suspend fun delete(draw: DrawEntity)
    suspend fun deleteDraw(drawId: Int, ticketId1: Int, ticketId2: Int) {
        deleteKeg(ticketId1)
        deleteKeg(ticketId2)
        deleteTicket(drawId)
    }
    suspend fun deleteTicket(drawId: Int)
    suspend fun deleteKeg(ticketId: Int)
    fun listDraw(): Flow<List<DrawEntity>>
}