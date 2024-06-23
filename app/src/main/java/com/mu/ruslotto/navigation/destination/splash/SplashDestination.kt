package com.mu.ruslotto.navigation.destination.splash

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mu.ruslotto.presentation.screen.splash.SplashScreen
import com.mu.ruslotto.presentation.utils.Constants

fun NavGraphBuilder.splash(
    toMain: () -> Unit,
) {
    composable(Constants.Routes.SPLASH_SCREEN) {
        SplashScreen(
            toMain = toMain
        )
    }
}
