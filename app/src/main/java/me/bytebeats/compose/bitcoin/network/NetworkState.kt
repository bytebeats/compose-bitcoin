package me.bytebeats.compose.bitcoin.network

/**
 * Created by bytebeats on 2021/11/23 : 17:03
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
sealed class NetworkState<out T> {
    object Loading : NetworkState<Nothing>()
    data class Error(val error: Throwable) : NetworkState<Nothing>()
    data class Success<T>(val data: T) : NetworkState<T>()
}
