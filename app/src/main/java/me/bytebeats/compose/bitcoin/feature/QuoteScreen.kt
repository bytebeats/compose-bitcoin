package me.bytebeats.compose.bitcoin.feature

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import me.bytebeats.compose.bitcoin.R
import me.bytebeats.compose.bitcoin.component.*
import me.bytebeats.compose.bitcoin.enums.QuoteTimeSpan
import me.bytebeats.compose.bitcoin.ui.UiState
import me.bytebeats.compose.bitcoin.ui.theme.ComposeBitcoinTheme
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
                        PriceHeader(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 15.dp, top = 15.dp, end = 15.dp),
                            currency = stringResource(id = R.string.bitcoin_btc),
                            price = state.quoteDetail.currentPrice,
                            changeRate = state.quoteDetail.changeRate,
                            isChangeRatePositive = state.isChangeStatusPositive()
                        )

                        TimeSpanTab(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 15.dp, top = 15.dp, end = 15.dp),
                            selectedTimeSpan = state.timeSpan
                        ) { timeSpan ->
                            quoteViewModel.fetchQuoteDetail(timeSpan)
                        }

                        Chart(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            lineDataSet = state.lineDataSet(
                                LocalContext.current
                            ),
                        )

                        Price(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 15.dp, top = 15.dp, end = 15.dp),
                            openPrice = state.quoteDetail.openPrice,
                            closePrice = state.quoteDetail.closePrice,
                            highestPrice = state.quoteDetail.highestPrice,
                            lowestPrice = state.quoteDetail.lowestPrice,
                            averagePrice = state.quoteDetail.averagePrice,
                            changePrice = state.quoteDetail.changePrice
                        )

                        AboutChart(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 15.dp, top = 20.dp, end = 15.dp),
                            aboutChart = state.quoteDetail.aboutChart
                        )
                    }
                }
            }
        }
    }

    LaunchedEffect(
        key1 = Unit,
        block = { quoteViewModel.fetchQuoteDetail(QuoteTimeSpan.MONTH) })
}

@Preview(showBackground = true, showSystemUi = true)
@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun QuoteScreenPreview() {
    ComposeBitcoinTheme {
        QuoteScreen()
    }
}