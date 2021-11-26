package me.bytebeats.compose.bitcoin.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.github.mikephil.charting.data.LineDataSet
import me.bytebeats.compose.bitcoin.model.StatsDetail

/**
 * Created by bytebeats on 2021/11/26 : 15:48
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

@Composable
fun StatsChart(modifier: Modifier = Modifier, lineDataSet: LineDataSet? = null) {
    Column {
        CurrencyStats()
//        TransactionsChart(modifier = modifier, lineDataSet = lineDataSet)
    }
}

@Composable
fun CurrencyStats() {
    Text(
        text = "Currency Stats",
        style = MaterialTheme.typography.h5,
        textAlign = TextAlign.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    )
}

@Composable
fun TransactionsChart(modifier: Modifier, stats: StatsDetail.Stats, detail: StatsDetail.Detail) {
    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        elevation = 10.dp
    ) {
        Column {

//            Chart(modifier, detail.transactionsEntries)
        }
    }
}

