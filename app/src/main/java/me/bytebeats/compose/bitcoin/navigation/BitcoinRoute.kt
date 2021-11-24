package me.bytebeats.compose.bitcoin.navigation

/**
 * Created by bytebeats on 2021/11/23 : 19:24
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
sealed class BitcoinRoute(val value: String) {
    object Splash : BitcoinRoute("Screen")
    object Quote : BitcoinRoute("Quote")
    object Stats : BitcoinRoute("Stats")
}
