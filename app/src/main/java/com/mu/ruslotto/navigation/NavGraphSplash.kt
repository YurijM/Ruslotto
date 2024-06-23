package com.mu.ruslotto.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mu.ruslotto.navigation.destination.first.first
import com.mu.ruslotto.navigation.destination.main.main
import com.mu.ruslotto.navigation.destination.splash.splash
import com.mu.ruslotto.presentation.utils.Constants

@Composable
fun NavGraphSplash(
    navControllerSplash: NavHostController
) {
    NavHost(
        navController = navControllerSplash,
        startDestination = Constants.Routes.SPLASH_SCREEN
    ) {
        splash(
            toMain = {
                navControllerSplash.navigate(Constants.Routes.MAIN_SCREEN)
            }
        )
        main()
    }
}