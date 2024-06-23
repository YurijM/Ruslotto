package com.mu.ruslotto.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mu.ruslotto.navigation.destination.first.first
import com.mu.ruslotto.navigation.destination.splash.splash
import com.mu.ruslotto.navigation.destination.main.main
import com.mu.ruslotto.presentation.utils.Constants

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Constants.Routes.FIRST_SCREEN
    ) {
        first()
    }

}