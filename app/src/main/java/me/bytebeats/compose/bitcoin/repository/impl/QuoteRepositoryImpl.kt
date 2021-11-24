package me.bytebeats.compose.bitcoin.repository.impl

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import me.bytebeats.compose.bitcoin.model.QuotePriceChartResponse
import me.bytebeats.compose.bitcoin.qualifier.IoDispatcher
import me.bytebeats.compose.bitcoin.repository.QuoteRepository
import me.bytebeats.compose.bitcoin.source.QuoteRemoteDataSource
import javax.inject.Inject

/**
 * Created by bytebeats on 2021/11/24 : 11:37
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
class QuoteRepositoryImpl @Inject constructor(
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher,
    private val quoteRemoteDataSource: QuoteRemoteDataSource
) : QuoteRepository {
    override suspend fun quotePriceChart(timeSpan: String): QuotePriceChartResponse =
        withContext(ioDispatcher) {
            quoteRemoteDataSource.quotePriceChart(timeSpan)
        }
}