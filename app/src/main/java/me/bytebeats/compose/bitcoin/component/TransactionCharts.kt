package me.bytebeats.compose.bitcoin.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
fun TransactionHeader(modifier: Modifier = Modifier, stats: StatsDetail.Stats) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stats.title,
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(bottom = 10.dp),
        )
        Text(
            text = stats.string(),
            style = MaterialTheme.typography.subtitle2,
            textAlign = TextAlign.Start,
        )
    }
}

@Composable
fun TransactionChart(modifier: Modifier, lineDataSet: LineDataSet? = null) {
    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        elevation = 10.dp
    ) {
        Chart(modifier = modifier, lineDataSet)
    }
}

