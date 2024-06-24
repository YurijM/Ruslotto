package com.mu.ruslotto.domain.repository

import com.mu.ruslotto.data.entity.KegEntity
import com.mu.ruslotto.domain.model.KegModel
import kotlinx.coroutines.flow.Flow

interface KegRepository {
    suspend fun update(keg: KegEntity)
    suspend fun delete(keg: KegEntity)
    fun listKeg(drawId: Int): Flow<List<KegModel>>
}