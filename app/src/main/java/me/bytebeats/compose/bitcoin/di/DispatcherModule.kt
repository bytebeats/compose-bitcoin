package me.bytebeats.compose.bitcoin.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import me.bytebeats.compose.bitcoin.qualifier.DefaultDispatcher
import me.bytebeats.compose.bitcoin.qualifier.IoDispatcher
import me.bytebeats.compose.bitcoin.qualifier.MainDispatcher

/**
 * Created by bytebeats on 2021/11/23 : 17:45
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {
    @Provides
    @DefaultDispatcher
    fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @Provides
    @IoDispatcher
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @MainDispatcher
    fun provideMainDispatcher(): CoroutineDispatcher = Dispatchers.Main
}