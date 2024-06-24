package com.mu.ruslotto.navigation.destination.draw

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mu.ruslotto.presentation.screen.draw.list.DrawListScreen
import com.mu.ruslotto.presentation.utils.Constants.Routes.DRAW_LIST_SCREEN

fun NavGraphBuilder.listDraw(
    toUpdate: (Int) -> Unit
) {
    composable(DRAW_LIST_SCREEN) {
        DrawListScreen(
            toUpdate = toUpdate
        )
    }
}

fun NavController.navigateToDrawList() {
    navigate(DRAW_LIST_SCREEN)
}


