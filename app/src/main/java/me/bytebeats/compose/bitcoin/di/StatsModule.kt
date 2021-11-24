package me.bytebeats.compose.bitcoin.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import me.bytebeats.compose.bitcoin.domain.StatsDetailUserCase
import me.bytebeats.compose.bitcoin.domain.impl.StatsDetailUserCaseImpl
import me.bytebeats.compose.bitcoin.repository.StatsRepository
import me.bytebeats.compose.bitcoin.repository.impl.StatsRepositoryImpl
import me.bytebeats.compose.bitcoin.service.StatsService
import retrofit2.Retrofit

/**
 * Created by bytebeats on 2021/11/24 : 11:40
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
@Module
@InstallIn(ViewModelComponent::class)
abstract class StatsModule {

    @Binds
    abstract fun bindStatsRepository(impl: StatsRepositoryImpl): StatsRepository

    @Binds
    abstract fun bindStatsDetailUserCase(impl: StatsDetailUserCaseImpl): StatsDetailUserCase

    companion object {
        @Provides
        fun provideStatsService(retrofit: Retrofit): StatsService =
            retrofit.create(StatsService::class.java)
    }
}