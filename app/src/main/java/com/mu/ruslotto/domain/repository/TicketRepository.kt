package com.mu.ruslotto.domain.repository

import com.mu.ruslotto.data.entity.TicketEntity
import kotlinx.coroutines.flow.Flow

interface TicketRepository {
    suspend fun update(ticket: TicketEntity)
   fun listTickets(drawId: Int) : Flow<List<TicketEntity>>
}