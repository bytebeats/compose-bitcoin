package me.bytebeats.compose.bitcoin.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import me.bytebeats.compose.bitcoin.domain.QuoteDetailUserCase
import me.bytebeats.compose.bitcoin.enums.QuoteTimeSpan
import me.bytebeats.compose.bitcoin.ui.UiState
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

    fun fetchQuoteDetail(timeSpan: QuoteTimeSpan) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = try {
                UiState.Success(
                    QuoteViewState(
                        quoteDetail = quoteDetailUserCase.quoteDetail(
                            timeSpan
                        )
                    )
                )
            } catch (e: Exception) {
                UiState.Error(e)
            }
        }
    }
}