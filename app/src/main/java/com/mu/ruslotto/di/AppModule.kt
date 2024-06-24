package com.mu.ruslotto.di

import android.app.Application
import androidx.room.Room
import com.mu.ruslotto.data.RuslottoDb
import com.mu.ruslotto.data.repository.DrawRepositoryImpl
import com.mu.ruslotto.data.repository.KegRepositoryImpl
import com.mu.ruslotto.data.repository.TicketRepositoryImpl
import com.mu.ruslotto.domain.repository.DrawRepository
import com.mu.ruslotto.domain.repository.KegRepository
import com.mu.ruslotto.domain.repository.TicketRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRuslottoDb(app: Application): RuslottoDb {
        return Room.databaseBuilder(
            app,
            RuslottoDb::class.java,
            "db_ruslotto"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDrawRepository(db: RuslottoDb): DrawRepository {
        return DrawRepositoryImpl(db.drawDao)
    }

    @Provides
    @Singleton
    fun provideTicketRepository(db: RuslottoDb): TicketRepository {
        return TicketRepositoryImpl(db.ticketDao)
    }

    @Provides
    @Singleton
    fun provideKegRepository(db: RuslottoDb): KegRepository {
        return KegRepositoryImpl(db.kegDao)
    }
}