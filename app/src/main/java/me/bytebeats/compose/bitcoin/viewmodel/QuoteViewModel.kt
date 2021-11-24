package me.bytebeats.compose.bitcoin.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import me.bytebeats.compose.bitcoin.domain.QuoteDetailUserCase
import me.bytebeats.compose.bitcoin.enums.QuoteTimeSpan
import me.bytebeats.compose.bitcoin.ui.UiState
import me.bytebeats.compose.bitcoin.util.APP_TAG
import me.bytebeats.compose.bitcoin.viewstate.QuoteViewState
import javax.inject.Inject

/**
 * Created by bytebeats on 2021/11/24 : 14:29
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val quoteDetailUserCase: QuoteDetailUserCase
) : ViewModel() {
    private val _uiState = mutableStateOf<UiState<QuoteViewState>>(UiState.Loading)

    val uiState: State<UiState<QuoteViewState>>
        get() = _uiState

    private val ceHandler = CoroutineExceptionHandler { _, throwable ->
        Log.i(APP_TAG, null, throwable)
    }

    fun fetchQuoteDetail(timeSpan: QuoteTimeSpan) {
        viewModelScope.launch(ceHandler) {
            _uiState.value = UiState.Loading
            try {
                _uiState.value = UiState.Success(
                    QuoteViewState(
                        quoteDetail = quoteDetailUserCase.quoteDetail(
                            timeSpan
                        )
                    )
                )
            } catch (e: Exception) {
                Log.i(APP_TAG, null, e)
                _uiState.value = UiState.Error(e)
            }
        }
    }
}