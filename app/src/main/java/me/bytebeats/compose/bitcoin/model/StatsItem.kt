package me.bytebeats.compose.bitcoin.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by bytebeats on 2021/11/24 : 20:36
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
@JsonClass(generateAdapter = true)
data class StatsItem(
    @Json(name = "x") val timestamp: Long,
    @Json(name = "y") val transactionsPerSecond: Double
)
