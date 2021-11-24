package me.bytebeats.compose.bitcoin.navigation

/**
 * Created by bytebeats on 2021/11/23 : 19:24
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
sealed class Screen(val route: String) {
    object Splash : Screen("Screen")
    object Quote : Screen("Quote")
}
