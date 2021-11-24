package me.bytebeats.compose.bitcoin.util.ktx

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform
import me.bytebeats.compose.bitcoin.network.NetworkState

/**
 * Created by bytebeats on 2021/11/23 : 17:06
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

fun <T, R> NetworkState<T>.map(transform: (T) -> R): NetworkState<R> {
    return when (this) {
        is NetworkState.Success -> NetworkState.Success(transform.invoke(data))
        is NetworkState.Error -> NetworkState.Error(error)//immutable state, so we create new UiState
        is NetworkState.Loading -> NetworkState.Loading
    }
}

fun <T> Flow<NetworkState<T>>.doOnSuccess(action: suspend (T) -> Unit): Flow<NetworkState<T>> =
    transform { state ->
        if (state is NetworkState.Success) {
            action.invoke(state.data)
        }
        return@transform emit(state)
    }

fun <T> Flow<NetworkState<T>>.doOnError(action: suspend (Throwable) -> Unit): Flow<NetworkState<T>> =
    transform { state ->
        if (state is NetworkState.Error) {
            action.invoke(state.error)
        }
        return@transform emit(state)
    }

fun <T> Flow<NetworkState<T>>.doOnLoading(action: suspend () -> Unit): Flow<NetworkState<T>> =
    transform { state ->
        if (state is NetworkState.Loading) {
            action.invoke()
        }
        return@transform emit(state)
    }
