package com.mu.ruslotto.data.repository

import com.mu.ruslotto.data.dao.TicketDao
import com.mu.ruslotto.data.entity.TicketEntity
import com.mu.ruslotto.domain.repository.TicketRepository
import kotlinx.coroutines.flow.Flow

class TicketRepositoryImpl(
    private val dao: TicketDao
) : TicketRepository {
    override suspend fun update(ticket: TicketEntity) {
        dao.update(ticket)
    }

    override fun listTickets(drawId: Int): Flow<List<TicketEntity>> {
        return dao.listTickets(drawId)
    }
}