package me.bytebeats.compose.bitcoin.source

import me.bytebeats.compose.bitcoin.model.QuotePriceChartResponse
import me.bytebeats.compose.bitcoin.service.QuoteService
import javax.inject.Inject

/**
 * Created by bytebeats on 2021/11/24 : 11:22
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
class QuoteRemoteDataSource @Inject constructor(private val quoteService: QuoteService) {
    suspend fun quotePriceChart(timeSpan: String): QuotePriceChartResponse =
        quoteService.quotePriceChart(timeSpan)
}