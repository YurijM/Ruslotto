package com.mu.ruslotto.utils

import android.util.Log
import android.widget.Toast

fun showToast(msg: String) {
    Toast.makeText(APP_ACTIVITY, msg, Toast.LENGTH_LONG).show()
}

fun toLog(msg: String) {
    Log.d(LOG_TAG, msg)
}
