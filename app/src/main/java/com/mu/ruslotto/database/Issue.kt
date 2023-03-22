package com.mu.ruslotto.database

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    "table_issues",
    /*indices = [
        Index(
            value = ["issue"],
            unique = true
        )
    ]*/
)
data class Issue(
    @PrimaryKey(true) var id: Int,
    var issue: Int
)
