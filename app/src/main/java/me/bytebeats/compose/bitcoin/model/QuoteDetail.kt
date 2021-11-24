package me.bytebeats.compose.bitcoin.model

import com.github.mikephil.charting.data.Entry
import me.bytebeats.compose.bitcoin.enums.QuotePriceChangeStatus
import me.bytebeats.compose.bitcoin.enums.QuoteTimeSpan

/**
 * Created by bytebeats on 2021/11/24 : 11:50
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
data class QuoteDetail(
    val currentPrice: String,
    val openPrice: String,
    val closePrice: String,
    val highestPrice: String,
    val lowestPrice: String,
    val averagePrice: String,
    val changePrice: String,
    val changeRate: String,
    val changeStatus: QuotePriceChangeStatus,
    val aboutChart: String,
    val timeSpan: QuoteTimeSpan,
    val chartEntries: List<Entry>
)
