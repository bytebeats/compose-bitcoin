package me.bytebeats.compose.bitcoin.domain.impl

import me.bytebeats.compose.bitcoin.domain.QuoteDetailUserCase
import me.bytebeats.compose.bitcoin.enums.QuoteTimeSpan
import me.bytebeats.compose.bitcoin.model.QuoteDetail
import me.bytebeats.compose.bitcoin.repository.QuoteRepository
import me.bytebeats.compose.bitcoin.util.convertToQuoteDetail

/**
 * Created by bytebeats on 2021/11/24 : 12:07
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
class QuoteDetailUserCaseImpl constructor(private val quoteRepository: QuoteRepository) :
    QuoteDetailUserCase {
    override suspend fun quoteDetail(timeSpan: QuoteTimeSpan): QuoteDetail = convertToQuoteDetail(
        response = quoteRepository.quotePriceChart(timeSpan.value),
        timeSpan = timeSpan
    )
}