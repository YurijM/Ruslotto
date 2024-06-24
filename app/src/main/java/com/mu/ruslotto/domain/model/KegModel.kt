package com.mu.ruslotto.domain.model

data class KegModel(
    val drawId: Int,
    val ticketId: Int,
    val kegId: Int,
    val ticket: Int,
    val row: Int,
    val column: Int,
    val keg: Int,
    val win: Boolean
)
