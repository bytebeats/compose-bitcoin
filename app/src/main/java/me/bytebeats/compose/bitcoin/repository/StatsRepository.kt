package me.bytebeats.compose.bitcoin.repository

import me.bytebeats.compose.bitcoin.model.StatsResponse

/**
 * Created by bytebeats on 2021/11/24 : 11:36
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
interface StatsRepository {
    suspend fun transactionsPerSecond(timeSpan: String, rollingAverage: String): StatsResponse
}