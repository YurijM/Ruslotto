package com.mu.ruslotto.data.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "table_draws",
    indices = [
        Index(
            value = ["date"],
            unique = true
        )
    ]
)
data class DrawEntity(
    @PrimaryKey(true) var id: Int,
    var date: String = ""
)
