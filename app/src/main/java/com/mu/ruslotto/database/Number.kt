package com.mu.ruslotto.database

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    "table_numbers",
    /*indices = [
        Index(
            value = ["ticket_id", "card", "row", "column"],
            unique = true
        ),
        Index(
            value = ["ticket_id", "card", "number"],
            unique = true
        )
    ],*/
    foreignKeys = [
        ForeignKey(
            entity = Ticket::class,
            parentColumns = ["id"],
            childColumns = ["ticket_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Number(
    @PrimaryKey(true) var id: Int,
    var card: Int,
    var row: Int,
    var column: Int,
    var number: Int,
    var ticket_id: Int
)
