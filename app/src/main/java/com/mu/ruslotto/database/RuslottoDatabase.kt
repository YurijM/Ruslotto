package com.mu.ruslotto.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        Issue::class,
        Ticket::class,
        Number::class
    ],
    version = 1
)
abstract class RuslottoDatabase : RoomDatabase() {
    abstract fun getRuslottoDao(): RuslottoDao

    companion object {
        @Volatile
        private var database: RuslottoDatabase? = null

        @Synchronized
        fun getInstance(context: Context): RuslottoDatabase {
            if (database == null) {
                database = Room.databaseBuilder(
                    context,
                    RuslottoDatabase::class.java,
                    "database"
                ).build()
            }

            return database as RuslottoDatabase
        }
    }
}