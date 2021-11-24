package me.bytebeats.compose.bitcoin.model

import com.github.mikephil.charting.data.Entry
import me.bytebeats.compose.bitcoin.enums.QuoteTimeSpan
import me.bytebeats.compose.bitcoin.enums.RollingAverageSpan

/**
 * Created by bytebeats on 2021/11/24 : 20:56
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
data class StatsDetail(
    val title: String,
    val unit: String,
    val period: String,
    val maxTransaction: Double,
    val aboutChart: String,
    val timeSpan: QuoteTimeSpan,
    val rollingAverageSpan: RollingAverageSpan,
    val transactionsEntries: List<Entry>,
)

