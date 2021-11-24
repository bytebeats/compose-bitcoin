package me.bytebeats.compose.bitcoin.component

import android.content.res.Configuration
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import me.bytebeats.compose.bitcoin.R
import me.bytebeats.compose.bitcoin.ui.theme.ComposeBitcoinTheme

/**
 * Created by bytebeats on 2021/11/24 : 10:44
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

@Composable
fun LoadingAnimation(modifier: Modifier = Modifier) {
    Card(modifier = modifier, elevation = 0.dp) {
        val lottieLoadingComposition by rememberLottieComposition(
            spec = LottieCompositionSpec.RawRes(
                R.raw.lottie_anim_loading
            )
        )
        LottieAnimation(
            composition = lottieLoadingComposition,
            iterations = LottieConstants.IterateForever
        )
    }
}

@Preview(showBackground = false)
@Preview(showBackground = false, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun LoadingAnimationPreview() {
    ComposeBitcoinTheme {
        LoadingAnimation(modifier = Modifier.size(70.dp))
    }
}