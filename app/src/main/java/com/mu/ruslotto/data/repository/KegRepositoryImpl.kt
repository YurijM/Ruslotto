package com.mu.ruslotto.data.repository

import com.mu.ruslotto.data.dao.KegDao
import com.mu.ruslotto.data.entity.KegEntity
import com.mu.ruslotto.domain.model.KegModel
import com.mu.ruslotto.domain.repository.KegRepository
import kotlinx.coroutines.flow.Flow

class KegRepositoryImpl(
    private val dao: KegDao
) : KegRepository {
    override suspend fun update(keg: KegEntity) {
        dao.update(keg)
    }

    override suspend fun delete(keg: KegEntity) {
        dao.delete(keg)
    }

    override fun listKeg(drawId: Int): Flow<List<KegModel>> {
        return dao.listKeg(drawId)
    }
}