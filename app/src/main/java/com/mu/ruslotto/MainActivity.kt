package com.mu.ruslotto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.mu.ruslotto.navigation.NavGraph
import com.mu.ruslotto.navigation.NavGraphSplash
import com.mu.ruslotto.ui.theme.RuslottoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navControllerSplash = rememberNavController()

            window.statusBarColor = getColor(R.color.color_application)
            window.navigationBarColor = getColor(R.color.color_application)

            RuslottoTheme {
                /*Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }*/
                NavGraphSplash(navControllerSplash)
            }
        }
    }
}
