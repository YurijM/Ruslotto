package com.mu.ruslotto.database

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2: Migration = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        //database.execSQL("ALTER TABLE table_issues ADD UNIQUE(issue) ON CONFLICT REPLACE")
        database.execSQL("CREATE UNIQUE INDEX idx_table_tickets_ticket ON table_tickets(ticket)")
    }

}