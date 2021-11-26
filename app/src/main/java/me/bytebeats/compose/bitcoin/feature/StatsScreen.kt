package me.bytebeats.compose.bitcoin.feature

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import me.bytebeats.compose.bitcoin.R
import me.bytebeats.compose.bitcoin.component.*
import me.bytebeats.compose.bitcoin.enums.QuoteTimeSpan
import me.bytebeats.compose.bitcoin.enums.RollingAverage
import me.bytebeats.compose.bitcoin.navigation.BitcoinRoute
import me.bytebeats.compose.bitcoin.network.NetworkState
import me.bytebeats.compose.bitcoin.viewmodel.StatsViewModel
import me.bytebeats.compose.bitcoin.viewstate.ErrorViewState
import me.bytebeats.compose.bitcoin.viewstate.StatsViewState

/**
 * Created by bytebeats on 2021/11/24 : 19:55
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

@Composable
fun StatsScreen(navController: NavController? = null) {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(id = R.string.popular_stats),
                    style = MaterialTheme.typography.h5,
                    color = MaterialTheme.colors.onPrimary
                )
            },
            backgroundColor = MaterialTheme.colors.primary,
            navigationIcon = {
                IconButton(onClick = { navController?.navigate(BitcoinRoute.Quote.value) }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "home_arrow_back")
                }
            }
        )
    }) {
        StatsContentScreen()
    }
}

@Composable
private fun StatsContentScreen(statsViewModel: StatsViewModel = hiltViewModel()) {
    val uiState by statsViewModel.networkState
    val swipeRefreshState =
        rememberSwipeRefreshState(isRefreshing = uiState is NetworkState.Loading)
    val scrollState = rememberScrollState()
    when (uiState) {
        is NetworkState.Loading -> {
            LoadingScreen()
        }
        is NetworkState.Error -> {
            ErrorScreen(errorViewState = ErrorViewState((uiState as NetworkState.Error).error)) {
                statsViewModel.fetchStatsDetail(QuoteTimeSpan.MONTH, RollingAverage.EIGHT_HOURS)
            }
        }
        is NetworkState.Success -> {
            val state = (uiState as NetworkState.Success<StatsViewState>).data
            Surface {
                SwipeRefresh(
                    state = swipeRefreshState,
                    onRefresh = {
                        statsViewModel.fetchStatsDetail(
                            state.statsDetail.timeSpan,
                            state.statsDetail.rollingAverage,
                        )
                    },
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Column(modifier = Modifier.verticalScroll(scrollState)) {
                        TimeSpanTab(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 15.dp, top = 15.dp, end = 15.dp),
                            selectedSpan = state.statsDetail.timeSpan
                        ) { span ->
                            statsViewModel.fetchStatsDetail(
                                span,
                                state.statsDetail.rollingAverage,
                            )
                        }
                        RollingAverageTab(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 15.dp, top = 15.dp, end = 15.dp),
                            selectedSpan = state.statsDetail.rollingAverage
                        ) { span ->
                            statsViewModel.fetchStatsDetail(
                                state.statsDetail.timeSpan,
                                span,
                            )
                        }
                        TransactionHeader(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 5.dp, top = 10.dp, end = 5.dp),
                            stats = state.statsDetail.stats,
                        )
                        TransactionChart(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 5.dp, top = 10.dp, end = 5.dp),
                            lineDataSet = state.lineDataSet(
                                LocalContext.current
                            ),
                        )
                        AboutChart(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 15.dp, top = 20.dp, end = 15.dp),
                            description = state.statsDetail.description
                        )
                    }
                }
            }
        }
    }

    LaunchedEffect(
        key1 = Unit,
        block = {
            statsViewModel.fetchStatsDetail(
                QuoteTimeSpan.MONTH,
                RollingAverage.EIGHT_HOURS
            )
        })
}