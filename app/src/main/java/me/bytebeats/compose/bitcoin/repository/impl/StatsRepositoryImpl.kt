package me.bytebeats.compose.bitcoin.repository.impl

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import me.bytebeats.compose.bitcoin.model.StatsResponse
import me.bytebeats.compose.bitcoin.qualifier.IoDispatcher
import me.bytebeats.compose.bitcoin.repository.StatsRepository
import me.bytebeats.compose.bitcoin.source.StatsRemoteDataSource
import javax.inject.Inject

/**
 * Created by bytebeats on 2021/11/24 : 11:37
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
class StatsRepositoryImpl @Inject constructor(
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher,
    private val statsRemoteDataSource: StatsRemoteDataSource
) : StatsRepository {
    override suspend fun transactionsPerSecond(
        timeSpan: String,
        rollingAverage: String
    ): StatsResponse = withContext(ioDispatcher) {
        statsRemoteDataSource.transactionsPerSecond(timeSpan, rollingAverage)
    }
}