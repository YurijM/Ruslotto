package com.mu.ruslotto.navigation.destination.first

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mu.ruslotto.presentation.screen.draw.DrawListScreen
import com.mu.ruslotto.presentation.utils.Constants

fun NavGraphBuilder.first() {
    composable(Constants.Routes.DRAW_LIST_SCREEN) {
        DrawListScreen()
    }
}
