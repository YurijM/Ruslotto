package com.mu.ruslotto.data.repository

import com.mu.ruslotto.data.dao.DrawDao
import com.mu.ruslotto.data.entity.DrawEntity
import com.mu.ruslotto.domain.repository.DrawRepository
import kotlinx.coroutines.flow.Flow

class DrawRepositoryImpl(
    private val dao: DrawDao
) : DrawRepository {
    override suspend fun update(draw: DrawEntity) {
        dao.update(draw)
    }

    override suspend fun delete(draw: DrawEntity) {
        dao.delete(draw)
    }

    override suspend fun deleteTicket(drawId: Int) {
        dao.deleteTicket(drawId)
    }

    override suspend fun deleteKeg(ticketId: Int) {
        dao.deleteKeg(ticketId)
    }

    override suspend fun deleteDraw(drawId: Int, ticketId1: Int, ticketId2: Int) {
        dao.deleteDraw(drawId, ticketId1, ticketId2)
    }

    override fun listDraw(): Flow<List<DrawEntity>> {
        return dao.listDraw()
    }
}