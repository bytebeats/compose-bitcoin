package me.bytebeats.compose.bitcoin.feature

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import me.bytebeats.compose.bitcoin.R
import me.bytebeats.compose.bitcoin.component.*
import me.bytebeats.compose.bitcoin.enums.QuoteTimeSpan
import me.bytebeats.compose.bitcoin.navigation.BitcoinRoute
import me.bytebeats.compose.bitcoin.network.NetworkState
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
private fun QuoteContentScreen(
    quoteViewModel: QuoteViewModel = hiltViewModel()
) {
    val uiState by quoteViewModel.networkState
    val swipeRefreshState =
        rememberSwipeRefreshState(isRefreshing = uiState is NetworkState.Loading)
    val scrollState = rememberScrollState()
    when (uiState) {
        is NetworkState.Loading -> {
            LoadingScreen()
        }
        is NetworkState.Error -> {
            ErrorScreen(errorViewState = ErrorViewState((uiState as NetworkState.Error).error)) {
                quoteViewModel.fetchQuoteDetail(QuoteTimeSpan.MONTH)
            }
        }
        is NetworkState.Success -> {
            val state = (uiState as NetworkState.Success<QuoteViewState>).data
            Surface {
                SwipeRefresh(
                    state = swipeRefreshState,
                    onRefresh = { quoteViewModel.fetchQuoteDetail(state.quoteDetail.timeSpan) },
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Column(modifier = Modifier.verticalScroll(scrollState)) {
                        PriceHeader(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 15.dp, top = 5.dp, end = 15.dp),
                            currency = stringResource(id = R.string.bitcoin_btc),
                            price = state.quoteDetail.currentPrice,
                            changeRate = state.quoteDetail.changeRate,
                            isChangeRatePositive = state.isChangeStatusPositive()
                        )

                        TimeSpanTab(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 15.dp, top = 15.dp, end = 15.dp),
                            selectedSpan = state.quoteDetail.timeSpan
                        ) { timeSpan ->
                            quoteViewModel.fetchQuoteDetail(timeSpan)
                        }

                        Chart(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 5.dp, top = 10.dp, end = 5.dp),
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
                            description = state.quoteDetail.aboutChart
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

@Composable
fun QuoteScreen(navController: NavController? = null) {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.onPrimary
                )
            },
            backgroundColor = MaterialTheme.colors.primary,
            actions = {
                TextButton(onClick = { navController?.navigate(BitcoinRoute.Stats.value) }) {
                    Text(
                        text = stringResource(id = R.string.stats),
                        style = MaterialTheme.typography.h6,
                        color = MaterialTheme.colors.onPrimary
                    )
                }
            }
        )
    }) {
        QuoteContentScreen()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun QuoteScreenPreview() {
    ComposeBitcoinTheme {
        QuoteScreen()
    }
}