package com.mu.ruslotto.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mu.ruslotto.navigation.destination.draw.listDraw
import com.mu.ruslotto.navigation.destination.draw.navigateToDrawList
import com.mu.ruslotto.navigation.destination.draw.navigateToDrawUpdate
import com.mu.ruslotto.navigation.destination.draw.updateDraw
import com.mu.ruslotto.presentation.utils.Constants

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Constants.Routes.DRAW_LIST_SCREEN
    ) {
        listDraw(
            toUpdate = { id ->
                navController.navigateToDrawUpdate(id)
            }
        )
        updateDraw(
            toDrawList = {
                navController.navigateToDrawList()
            }
        )
    }

}