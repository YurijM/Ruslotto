package com.mu.ruslotto.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "table_kegs",
    indices = [
        Index(
            value = ["ticket_id", "card", "row", "column"],
            unique = true
        ),
        Index(
            value = ["ticket_id", "card", "keg"],
            unique = true
        )
    ],
    foreignKeys = [
        ForeignKey(
            entity = TicketEntity::class,
            parentColumns = ["id"],
            childColumns = ["ticket_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class KegEntity(
    @PrimaryKey(true) var id: Int,
    @ColumnInfo(name = "ticket_id") var ticketId: Int,
    var card: Int,
    var row: Int,
    var column: Int,
    var keg: Int,
    var win: Boolean
)
