package me.bytebeats.compose.bitcoin.feature

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import me.bytebeats.compose.bitcoin.enums.QuoteTimeSpan
import me.bytebeats.compose.bitcoin.ui.UiState
import me.bytebeats.compose.bitcoin.viewmodel.QuoteViewModel
import me.bytebeats.compose.bitcoin.viewstate.ErrorViewState
import me.bytebeats.compose.bitcoin.viewstate.QuoteViewState

/**
 * Created by bytebeats on 2021/11/24 : 14:36
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

@Composable
fun QuoteScreen(quoteViewModel: QuoteViewModel = hiltViewModel()) {
    val uiState by quoteViewModel.uiState
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = uiState is UiState.Loading)
    val scrollState = rememberScrollState()
    when (uiState) {
        is UiState.Loading -> {
            LoadingScreen()
        }
        is UiState.Error -> {
            ErrorScreen(errorViewState = ErrorViewState((uiState as UiState.Error).error)) {
                quoteViewModel.fetchQuoteDetail(QuoteTimeSpan.MONTH)
            }
        }
        is UiState.Success -> {
            val state = (uiState as UiState.Success<QuoteViewState>).data
            Surface {
                SwipeRefresh(
                    state = swipeRefreshState,
                    onRefresh = { quoteViewModel.fetchQuoteDetail(state.timeSpan) },
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Column(modifier = Modifier.verticalScroll(scrollState)) {
                        // TODO: content here
                    }
                }
            }
        }
    }
}