package com.mu.ruslotto.models

import java.io.Serializable

data class TicketModel(
    val id: Int,
    val card: Int,
    val row: Int,
    val column: Int,
    val number: Int,
    var did_keg_win: Boolean
) : Serializable
