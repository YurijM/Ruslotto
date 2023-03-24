package com.mu.ruslotto.database

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    "table_issues",
    indices = [
        Index(
            value = ["date"],
            unique = true
        )
    ]
)
data class Issue(
    @PrimaryKey(true) var id: Int,
    var date: String
) : Serializable
