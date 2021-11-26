package me.bytebeats.compose.bitcoin.domain.impl

import me.bytebeats.compose.bitcoin.domain.StatsDetailUserCase
import me.bytebeats.compose.bitcoin.enums.QuoteTimeSpan
import me.bytebeats.compose.bitcoin.enums.RollingAverage
import me.bytebeats.compose.bitcoin.model.StatsDetail
import me.bytebeats.compose.bitcoin.repository.StatsRepository
import me.bytebeats.compose.bitcoin.util.convertToStatsDetail
import javax.inject.Inject

/**
 * Created by bytebeats on 2021/11/24 : 12:07
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
class StatsDetailUserCaseImpl @Inject constructor(private val statsRepository: StatsRepository) :
    StatsDetailUserCase {
    override suspend fun statsDetail(
        timeSpan: QuoteTimeSpan,
        rollingAverage: RollingAverage
    ): StatsDetail = convertToStatsDetail(
        response = statsRepository.transactionsPerSecond(
            timeSpan = timeSpan.value,
            rollingAverage = rollingAverage.value
        ),
        timeSpan = timeSpan,
        rollingAverage = rollingAverage
    )
}