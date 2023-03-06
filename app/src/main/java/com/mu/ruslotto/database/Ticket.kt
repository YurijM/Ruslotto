package com.mu.ruslotto.database

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    "table_tickets",
    foreignKeys = [
        ForeignKey(
            entity = Issue::class,
            parentColumns = ["id"],
            childColumns = ["issue_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Ticket(
    @PrimaryKey(true) var id: Int,
    var ticket: String,
    var issue_id: Int
)
