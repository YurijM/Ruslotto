package com.mu.ruslotto.database

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        Issue::class,
        Ticket::class,
        Number::class
    ],
    version = 4,
    autoMigrations = [
        AutoMigration(from = 1, to = 2),
        AutoMigration(from = 2, to = 3),
        AutoMigration(from = 3, to = 4)
    ],
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
                    //.createFromAsset("database/bus_schedule.db")
                    //.addMigrations((MIGRATION_1_2))
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