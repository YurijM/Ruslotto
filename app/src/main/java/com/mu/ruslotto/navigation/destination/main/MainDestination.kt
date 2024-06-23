package com.mu.ruslotto.navigation.destination.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mu.ruslotto.presentation.screen.main.MainScreen
import com.mu.ruslotto.presentation.utils.Constants

fun NavGraphBuilder.main() {
    composable(Constants.Routes.MAIN_SCREEN) {
        MainScreen()
    }
}
