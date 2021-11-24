package me.bytebeats.compose.bitcoin.service

import me.bytebeats.compose.bitcoin.model.StatsResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by bytebeats on 2021/11/24 : 20:33
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
interface StatsService {
    @GET("charts/transactions-per-second")
    suspend fun transactionsPerSecond(
        @Query("timespan")
        timeSpan: String,
        @Query("rollingAverage")
        rollingAverage: String
    ): StatsResponse
}