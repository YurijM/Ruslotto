package com.mu.ruslotto.presentation.screen.draw

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.mu.ruslotto.R
import com.mu.tote2024.presentation.components.AppTitle

@Composable
fun DrawListScreen() {
    AppTitle(
        title = stringResource(R.string.draws_list),
    )
}