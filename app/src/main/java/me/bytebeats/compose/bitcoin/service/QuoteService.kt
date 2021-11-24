package me.bytebeats.compose.bitcoin.service

import me.bytebeats.compose.bitcoin.model.QuotePriceChartResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by bytebeats on 2021/11/24 : 11:11
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
interface QuoteService {
    @GET("charts/market-price")
    suspend fun quotePriceChart(@Query("timespan") timeSpan: String): QuotePriceChartResponse
}