package me.bytebeats.compose.bitcoin.feature

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.bytebeats.compose.bitcoin.component.LoadingAnimation
import me.bytebeats.compose.bitcoin.ui.theme.ComposeBitcoinTheme

/**
 * Created by bytebeats on 2021/11/24 : 10:42
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Surface(modifier = modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            LoadingAnimation(modifier = Modifier.size(80.dp))
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun LoadingScreenPreview() {
    ComposeBitcoinTheme {
        LoadingScreen(modifier = Modifier.fillMaxSize())
    }
}