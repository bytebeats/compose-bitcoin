package me.bytebeats.compose.bitcoin.feature

import android.content.res.Configuration
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import me.bytebeats.compose.bitcoin.R
import me.bytebeats.compose.bitcoin.navigation.Screen
import me.bytebeats.compose.bitcoin.ui.theme.ComposeBitcoinTheme

/**
 * Created by bytebeats on 2021/11/23 : 19:31
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

@Composable
fun SplashScreen(
    navController: NavController? = null,
    alphaAnimationTargetValue: Float = 0F,
    alphaAnimationDurationMillis: Int = 1000
) {
    Surface {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            contentAlignment = Alignment.Center,
        ) {
            var targetValue by remember {
                mutableStateOf(alphaAnimationTargetValue)
            }

            val alpha by animateFloatAsState(
                targetValue = targetValue,
                animationSpec = tween(alphaAnimationDurationMillis),
                finishedListener = {
                    navController?.popBackStack()
                    navController?.navigate(Screen.Quote.route)
                },
            )
            Image(
                painter = painterResource(id = R.drawable.ic_splash),
                contentDescription = null,
                modifier = Modifier.alpha(alpha)
            )
            LaunchedEffect(key1 = Unit, block = { targetValue = 1F })
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    ComposeBitcoinTheme {
        SplashScreen(alphaAnimationTargetValue = 1F)
    }
}