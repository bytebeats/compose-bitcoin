package me.bytebeats.compose.bitcoin.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.bytebeats.compose.bitcoin.feature.QuoteScreen
import me.bytebeats.compose.bitcoin.feature.SplashScreen
import me.bytebeats.compose.bitcoin.feature.StatsScreen

/**
 * Created by bytebeats on 2021/11/23 : 19:25
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

@Composable
fun ComposeBitcoinApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = BitcoinRoute.Splash.value) {
        composable(route = BitcoinRoute.Splash.value) {
            SplashScreen(navController = navController)
        }
        composable(route = BitcoinRoute.Quote.value) {
            QuoteScreen(navController = navController)
        }
        composable(route = BitcoinRoute.Stats.value) {
            StatsScreen(navController = navController)
        }
    }
}