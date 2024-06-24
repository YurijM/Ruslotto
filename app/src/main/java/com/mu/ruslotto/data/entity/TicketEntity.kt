package com.mu.ruslotto.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    "table_tickets",
    indices = [
        Index(
            value = ["draw_id", "ticket"],
            unique = true
        )
    ],
    foreignKeys = [
        ForeignKey(
            entity = DrawEntity::class,
            parentColumns = ["id"],
            childColumns = ["draw_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class TicketEntity(
    @PrimaryKey(true) var id: Int,
    @ColumnInfo(name = "draw_id") var drawId: Int,
    var ticket: String
)
