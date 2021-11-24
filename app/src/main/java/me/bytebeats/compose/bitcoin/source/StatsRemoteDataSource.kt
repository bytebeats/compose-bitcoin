package me.bytebeats.compose.bitcoin.source

import me.bytebeats.compose.bitcoin.model.StatsResponse
import me.bytebeats.compose.bitcoin.service.StatsService
import javax.inject.Inject

/**
 * Created by bytebeats on 2021/11/24 : 11:22
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
class StatsRemoteDataSource @Inject constructor(private val statsService: StatsService) {
    suspend fun transactionsPerSecond(
        timeSpan: String,
        rollingAverage: String
    ): StatsResponse = statsService.transactionsPerSecond(timeSpan, rollingAverage)
}