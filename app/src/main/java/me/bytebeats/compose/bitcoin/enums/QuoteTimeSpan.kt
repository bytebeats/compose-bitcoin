package me.bytebeats.compose.bitcoin.enums

/**
 * Created by bytebeats on 2021/11/24 : 11:44
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
enum class QuoteTimeSpan(val value: String) {
    DAY("1days"),
    WEEK("7days"),
    MONTH("30days"),
    TWO_MONTHS("60days"),
    THREE_MONTHS("90days"),
    ONE_YEAR("365days"),
}