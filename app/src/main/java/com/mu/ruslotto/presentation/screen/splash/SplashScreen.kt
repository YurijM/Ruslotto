package com.mu.ruslotto.presentation.screen.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mu.ruslotto.R
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SplashScreen(
    toMain: () -> Unit
) {
    val scale = remember {
        Animatable(0f)
    }
    /*val scaleText = remember {
        Animatable(0f)
    }*/

    /*val developmentText = stringResource(R.string.design) + "\n"
    val companyText = stringResource(R.string.company)
    val text = buildAnnotatedString {
        append("$developmentText ")
        withStyle(
            style = SpanStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Black
            )
        ) {
            pushStringAnnotation(tag = companyText, annotation = companyText)
            append(companyText)
        }
    }*/

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
            modifier = Modifier.fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFFEF9A9A),
                            Color(0xFFFFEBEE)
                        )
                    ),
                    shape = RoundedCornerShape(4.dp)
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.scale(scale.value).size(148.dp),
                painter = painterResource(id = R.drawable.lotto_title),
                contentDescription = "Logo"
            )
            Image(
                modifier = Modifier.scale(scale.value),
                painter = painterResource(id = R.drawable.lotto_kegs),
                contentDescription = "Logo"
            )
            /*AssistChip(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .scale(scaleText.value),
                onClick = { *//*TODO*//* },
                label = {
                    Text(
                        text = text,
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "settings"
                    )
                }
            )*/
        }
    }
}
