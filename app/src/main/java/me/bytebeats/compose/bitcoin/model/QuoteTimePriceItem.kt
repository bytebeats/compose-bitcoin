package me.bytebeats.compose.bitcoin.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by bytebeats on 2021/11/24 : 11:14
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

@JsonClass(generateAdapter = true)
data class QuoteTimePriceItem(
    @Json(name = "x") val timestamp: Long,
    @Json(name = "y") val price: Double
)
