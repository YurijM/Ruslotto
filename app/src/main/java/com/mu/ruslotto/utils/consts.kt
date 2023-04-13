package com.mu.ruslotto.utils

import com.mu.ruslotto.database.RuslottoDao
import com.mu.ruslotto.database.RuslottoRepository
import com.mu.ruslotto.ui.main.MainActivity


lateinit var APP_ACTIVITY: MainActivity

const val LOG_TAG = "logRuslotto"
const val YEAR_START = 2023

lateinit var DAO: RuslottoDao
lateinit var REPOSITORY: RuslottoRepository

const val ROWS_COUNT = 3
const val COLS_COUNT = 9