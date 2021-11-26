package me.bytebeats.compose.bitcoin.component

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.bytebeats.compose.bitcoin.model.StatsDetail
import me.bytebeats.compose.bitcoin.ui.theme.ComposeBitcoinTheme

/**
 * Created by bytebeats on 2021/11/26 : 15:18
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

@Composable
fun StatsCardItem(title: String, summary: String, description: String) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(180.dp),
        shape = RoundedCornerShape(5.dp),
        elevation = 10.dp,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = title,
                modifier = Modifier.padding(5.dp),
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.onSurface
            )
            Text(
                text = summary,
                modifier = Modifier.padding(5.dp),
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = description,
                modifier = Modifier.padding(5.dp),
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.onSurface,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
fun StatsList(stats: List<StatsDetail.Stats>, horizontal: Boolean = true) {

    if (horizontal) {
        LazyRow {
            items(stats) { s ->
                StatsCardItem(title = s.title, summary = s.period, description = s.description)
            }
        }
    } else {
        LazyColumn(content = {
            items(stats) { s ->
                StatsCardItem(title = s.title, summary = s.period, description = s.description)
            }
        })
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_MASK)
@Composable
private fun StatsListPreview() {
    ComposeBitcoinTheme {
        StatsList(
            stats = listOf(
                StatsDetail.Stats(
                    title = "Market Price",
                    unit = "$36,980,20000",
                    period = "$36,980,20000",
                    description = "The average USD market price across major bitcoin exchange"
                ),
                StatsDetail.Stats(
                    title = "Market Price",
                    unit = "$36,980,200",
                    period = "$36,980,200",
                    description = "The average USD market price across major bitcoin exchange"
                )
            )
        )
    }
}