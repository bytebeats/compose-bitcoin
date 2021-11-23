package me.bytebeats.compose.bitcoin.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.bytebeats.compose.bitcoin.feature.SplashScreen

/**
 * Created by bytebeats on 2021/11/23 : 19:25
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

@Composable
fun ComposeBitcoinApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(route = Screen.Splash.route) {
            SplashScreen()
        }
        composable(route = Screen.Market.route) {

        }
    }
}