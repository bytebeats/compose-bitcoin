package me.bytebeats.compose.bitcoin.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import me.bytebeats.compose.bitcoin.domain.StatsDetailUserCase
import me.bytebeats.compose.bitcoin.enums.QuoteTimeSpan
import me.bytebeats.compose.bitcoin.enums.RollingAverageSpan
import me.bytebeats.compose.bitcoin.network.NetworkState
import me.bytebeats.compose.bitcoin.util.APP_TAG
import me.bytebeats.compose.bitcoin.viewstate.StatsViewState
import javax.inject.Inject

/**
 * Created by bytebeats on 2021/11/24 : 14:29
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

@HiltViewModel
class StatsViewModel @Inject constructor(
    private val statsDetailUserCase: StatsDetailUserCase
) : ViewModel() {
    private val _networkState = mutableStateOf<NetworkState<StatsViewState>>(NetworkState.Loading)

    val networkState: State<NetworkState<StatsViewState>>
        get() = _networkState

    private val ceHandler = CoroutineExceptionHandler { _, throwable ->
        Log.i(APP_TAG, null, throwable)
    }

    fun fetchStatsDetail(timeSpan: QuoteTimeSpan, rollingAverageSpan: RollingAverageSpan) {
        viewModelScope.launch(ceHandler) {
            _networkState.value = NetworkState.Loading
            try {
                _networkState.value = NetworkState.Success(
                    StatsViewState(
                        statsDetail = statsDetailUserCase.statsDetail(
                            timeSpan, rollingAverageSpan
                        )
                    )
                )
            } catch (e: Exception) {
                _networkState.value = NetworkState.Error(e)
            }
        }
    }
}