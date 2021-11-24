package me.bytebeats.compose.bitcoin.feature

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import me.bytebeats.compose.bitcoin.R
import me.bytebeats.compose.bitcoin.navigation.BitcoinRoute
import me.bytebeats.compose.bitcoin.viewmodel.StatsViewModel

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
                    text = stringResource(id = R.string.stats),
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
    // TODO: inflate StatsContentScreen
}