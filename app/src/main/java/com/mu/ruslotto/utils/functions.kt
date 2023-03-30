package com.mu.ruslotto.utils

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

fun showToast(msg: String) {
    Toast.makeText(APP_ACTIVITY, msg, Toast.LENGTH_LONG).show()
}

fun toLog(msg: String) {
    Log.d(LOG_TAG, msg)
}

fun Calendar.dateToString(): String {
    return padLeftZero(this.get(Calendar.DAY_OF_MONTH)) +
            ".${padLeftZero(this.get(Calendar.MONTH) + 1)}" +
            ".${this.get(Calendar.YEAR)}"
}

@SuppressLint("SimpleDateFormat")
fun Calendar.toRoom(): String =
    SimpleDateFormat("yyyy-MM-dd")
        .format(this.time)

fun padLeftZero(value: Int): String {
    return if (value < 10) "0$value" else value.toString()
}
