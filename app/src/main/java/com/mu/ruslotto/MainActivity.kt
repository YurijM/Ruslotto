package com.mu.ruslotto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.mu.ruslotto.navigation.NavGraphSplash
import com.mu.ruslotto.ui.theme.RuslottoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(getColor(R.color.color_application), getColor(R.color.color_application)),
            navigationBarStyle = SystemBarStyle.light(getColor(R.color.color_application), getColor(R.color.color_application)),
        )
        setContent {
            val navControllerSplash = rememberNavController()

            /*window.statusBarColor = getColor(R.color.color_application)
            window.navigationBarColor = getColor(R.color.color_application)*/

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
