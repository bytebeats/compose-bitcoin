package me.bytebeats.compose.bitcoin.util

import com.github.mikephil.charting.data.Entry
import me.bytebeats.compose.bitcoin.enums.QuotePriceChangeStatus
import me.bytebeats.compose.bitcoin.enums.QuoteTimeSpan
import me.bytebeats.compose.bitcoin.enums.RollingAverage
import me.bytebeats.compose.bitcoin.model.*
import me.bytebeats.compose.bitcoin.util.ktx.changeRateOf
import me.bytebeats.compose.bitcoin.util.ktx.orZero
import me.bytebeats.compose.bitcoin.util.ktx.toCurrency

/**
 * Created by bytebeats on 2021/11/24 : 11:56
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

internal fun convertToQuoteDetail(
    response: QuotePriceChartResponse,
    timeSpan: QuoteTimeSpan
): QuoteDetail {
    val prices = response.values.map { it.price }
    val firstPrice = prices.firstOrNull().orZero()
    val lastPrice = prices.lastOrNull().orZero()

    return QuoteDetail(
        currentPrice = lastPrice.toCurrency(),
        openPrice = firstPrice.toCurrency(),
        closePrice = lastPrice.toCurrency(),
        highestPrice = prices.maxOrNull().toCurrency(),
        lowestPrice = prices.minOrNull().toCurrency(),
        averagePrice = prices.average().toCurrency(),
        changePrice = (lastPrice - firstPrice).toCurrency(),
        changeRate = "${firstPrice.changeRateOf(lastPrice)}%",
        changeStatus = changeStatus(firstPrice, lastPrice),
        aboutChart = response.description,
        timeSpan = timeSpan,
        chartEntries = response.values.map { convertToEntry(it) }
    )
}

internal fun convertToEntry(item: QuoteTimePriceItem): Entry =
    Entry(item.timestamp.toFloat(), item.price.toFloat())

internal fun changeStatus(price: Double, baseline: Double): QuotePriceChangeStatus =
    if (price >= baseline) QuotePriceChangeStatus.POSITIVE else QuotePriceChangeStatus.NEGATIVE

internal fun convertToEntry(item: StatsItem): Entry =
    Entry(item.timestamp.toFloat(), item.transactionsPerSecond.toFloat())

internal fun convertToStatsDetail(
    response: StatsResponse,
    timeSpan: QuoteTimeSpan,
    rollingAverage: RollingAverage
): StatsDetail {
    val transactions = response.values.map { it.transactionsPerSecond }
    val maxTransaction = transactions.maxOrNull().orZero()

    return StatsDetail(
        title = response.name,
        unit = response.unit,
        period = response.period,
        description = response.description,
        maxTransaction = maxTransaction,
        timeSpan = timeSpan,
        rollingAverage = rollingAverage,
        transactionsEntries = response.values.map { convertToEntry(it) }
    )
}
