package com.mu.ruslotto.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mu.ruslotto.data.dao.DrawDao
import com.mu.ruslotto.data.dao.KegDao
import com.mu.ruslotto.data.dao.TicketDao
import com.mu.ruslotto.data.entity.DrawEntity
import com.mu.ruslotto.data.entity.KegEntity
import com.mu.ruslotto.data.entity.TicketEntity

@Database(
    entities = [
        DrawEntity::class,
        TicketEntity::class,
        KegEntity::class
    ],
    version = 1
)
abstract class RuslottoDb : RoomDatabase() {
    abstract val drawDao: DrawDao
    abstract val ticketDao: TicketDao
    abstract val kegDao: KegDao
}