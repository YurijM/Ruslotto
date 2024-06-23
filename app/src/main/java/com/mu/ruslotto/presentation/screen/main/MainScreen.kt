package com.mu.ruslotto.presentation.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mu.ruslotto.navigation.NavGraph
import com.mu.ruslotto.presentation.utils.Constants.Routes.FIRST_SCREEN
import com.mu.ruslotto.presentation.utils.Constants.Routes.MAIN_SCREEN

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding()
                ),
            //color = MaterialTheme.colorScheme.surface,
            //contentColor = MaterialTheme.colorScheme.onSurface,
        ) {
            NavGraph(navController = navController)

        }
    }
}