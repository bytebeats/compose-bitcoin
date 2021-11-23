package me.bytebeats.compose.bitcoin.ui

/**
 * Created by bytebeats on 2021/11/23 : 17:03
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
sealed class UiState<out T> {
    object Loading : UiState<Nothing>()
    data class Error(val error: Throwable) : UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
}
