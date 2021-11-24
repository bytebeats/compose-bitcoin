package me.bytebeats.compose.bitcoin.domain

import me.bytebeats.compose.bitcoin.enums.QuoteTimeSpan
import me.bytebeats.compose.bitcoin.model.QuoteDetail

/**
 * Created by bytebeats on 2021/11/24 : 12:06
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
interface QuoteDetailUserCase {
    suspend fun quoteDetail(timeSpan: QuoteTimeSpan): QuoteDetail
}