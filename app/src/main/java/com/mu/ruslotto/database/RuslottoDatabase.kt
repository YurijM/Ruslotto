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
        private var INSTANCE: RuslottoDatabase? = null

        fun getDatabase(context: Context): RuslottoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    RuslottoDatabase::class.java,
                    "app_database")
                    //.createFromAsset("database/bus_schedule.db")
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