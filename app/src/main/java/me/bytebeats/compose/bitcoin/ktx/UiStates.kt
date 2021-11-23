package me.bytebeats.compose.bitcoin.ktx

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform
import me.bytebeats.compose.bitcoin.ui.UiState

/**
 * Created by bytebeats on 2021/11/23 : 17:06
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

fun <T, R> UiState<T>.map(transform: (T) -> R): UiState<R> {
    return when (this) {
        is UiState.Success -> UiState.Success(transform.invoke(data))
        is UiState.Error -> UiState.Error(error)//immutable state, so we create new UiState
        is UiState.Loading -> UiState.Loading
    }
}

fun <T> Flow<UiState<T>>.doOnSuccess(action: suspend (T) -> Unit): Flow<UiState<T>> =
    transform { state ->
        if (state is UiState.Success) {
            action.invoke(state.data)
        }
        return@transform emit(state)
    }

fun <T> Flow<UiState<T>>.doOnError(action: suspend (Throwable) -> Unit): Flow<UiState<T>> =
    transform { state ->
        if (state is UiState.Error) {
            action.invoke(state.error)
        }
        return@transform emit(state)
    }

fun <T> Flow<UiState<T>>.doOnLoading(action: suspend () -> Unit): Flow<UiState<T>> =
    transform { state ->
        if (state is UiState.Loading) {
            action.invoke()
        }
        return@transform emit(state)
    }
