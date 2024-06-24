package com.mu.ruslotto.presentation.screen.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mu.ruslotto.R
import com.mu.ruslotto.ui.theme.Color1
import com.mu.ruslotto.ui.theme.Color2
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    toMain: () -> Unit
) {
    val scale = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 3000,
                easing = {
                    OvershootInterpolator(5f).getInterpolation(it)
                }
            )
        )
        delay(1000L)

        toMain()
    }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color2,
                            Color1
                        )
                    ),
                    shape = RoundedCornerShape(4.dp)
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .scale(scale.value)
                    .size(148.dp),
                painter = painterResource(id = R.drawable.lotto_title),
                contentDescription = "Logo"
            )
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                modifier = Modifier.scale(scale.value),
                painter = painterResource(id = R.drawable.lotto_kegs),
                contentDescription = "Logo"
            )
        }
    }
}
