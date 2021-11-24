package me.bytebeats.compose.bitcoin.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by bytebeats on 2021/11/24 : 11:15
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
@JsonClass(generateAdapter = true)
data class QuotePriceChartResponse(
    @Json(name = "description")
    val description: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "period")
    val period: String,
    @Json(name = "status")
    val status: String,
    @Json(name = "unit")
    val unit: String,
    @Json(name = "values")
    val values: List<QuoteTimePriceItem>
)
