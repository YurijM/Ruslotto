package com.mu.ruslotto.presentation.screen.draw

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.mu.ruslotto.R
import com.mu.ruslotto.presentation.components.AppTitle

@SuppressLint("DefaultLocale")
@Composable
fun DrawListScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
    AppTitle(
        title = stringResource(R.string.draws_list),
    )
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items((1..12).toList()) {
            DrawItemScreen(date = "01.${it.toString().padStart(2, '0')}.2023")
        }
    }
    }
}