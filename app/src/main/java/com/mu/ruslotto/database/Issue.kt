package com.mu.ruslotto.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("table_issues")
data class Issue(
    @PrimaryKey(true) var id: Int,
    var issue: Int
)
