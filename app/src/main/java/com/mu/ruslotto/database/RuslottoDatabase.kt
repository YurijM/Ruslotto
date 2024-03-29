package com.mu.ruslotto.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        Issue::class,
        Ticket::class,
        Keg::class
    ],
    version = 1,
    /*autoMigrations = [
        AutoMigration(from = 1, to = 2),
    ],*/
    exportSchema = true
)
abstract class RuslottoDatabase : RoomDatabase() {
    abstract fun getRuslottoDao(): RuslottoDao

    companion object {
        @Volatile
        private var INSTANCE: RuslottoDatabase? = null

        fun getDatabase(context: Context): RuslottoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    RuslottoDatabase::class.java,
                    "db_ruslotto")
                    .build()
                INSTANCE = instance
                instance
            }
        }

        /*@Synchronized
        fun getInstance(context: Context): RuslottoDatabase {
            if (database == null) {
                database = Room.databaseBuilder(
                    context,
                    RuslottoDatabase::class.java,
                    "database"
                ).build()
            }

            return database as RuslottoDatabase
        }*/
    }
}