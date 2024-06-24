package com.mu.ruslotto.navigation.destination.draw

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mu.ruslotto.presentation.screen.draw.update.DrawUpdateScreen
import com.mu.ruslotto.presentation.utils.Constants.KEY_ID
import com.mu.ruslotto.presentation.utils.Constants.Routes.DRAW_UPDATE_SCREEN

fun NavGraphBuilder.updateDraw(
    toDrawList: () -> Unit
) {
    composable("$DRAW_UPDATE_SCREEN/{$KEY_ID}") {
        DrawUpdateScreen(
            toDrawList = toDrawList
        )
    }
}

fun NavController.navigateToDrawUpdate(id: Int) {
    navigate("$DRAW_UPDATE_SCREEN/$id")
}
