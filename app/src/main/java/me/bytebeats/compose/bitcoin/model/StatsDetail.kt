package me.bytebeats.compose.bitcoin.model

import com.github.mikephil.charting.data.Entry
import me.bytebeats.compose.bitcoin.enums.QuoteTimeSpan
import me.bytebeats.compose.bitcoin.enums.RollingAverage

/**
 * Created by bytebeats on 2021/11/24 : 20:56
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
data class StatsDetail(
    val title: String,
    val unit: String,
    val period: String,
    val description: String,
    val maxTransaction: Double,
    val timeSpan: QuoteTimeSpan,
    val rollingAverage: RollingAverage,
    val transactionsEntries: List<Entry>,
) {
    val stats: Stats get() = Stats(title, unit, period, description)

    val detail: Detail
        get() = Detail(
            maxTransaction,
            timeSpan,
            rollingAverage,
            transactionsEntries
        )

    data class Stats(
        val title: String,
        val unit: String,
        val period: String,
        val description: String,
    )

    data class Detail(
        val maxTransaction: Double,
        val timeSpan: QuoteTimeSpan,
        val rollingAverage: RollingAverage,
        val transactionsEntries: List<Entry>,
    )
}


