package me.bytebeats.compose.bitcoin.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import me.bytebeats.compose.bitcoin.repository.QuoteRepository
import me.bytebeats.compose.bitcoin.repository.impl.QuoteRepositoryImpl
import me.bytebeats.compose.bitcoin.service.QuoteService
import me.bytebeats.compose.bitcoin.usercase.QuoteDetailUserCase
import me.bytebeats.compose.bitcoin.usercase.impl.QuoteDetailUserCaseImpl
import retrofit2.Retrofit

/**
 * Created by bytebeats on 2021/11/24 : 11:40
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
@Module
@InstallIn(ViewModelComponent::class)
abstract class QuoteModule {

    @Binds
    abstract fun bindQuoteRepository(impl: QuoteRepositoryImpl): QuoteRepository

    @Binds
    abstract fun bindQuoteDetailUserCase(impl: QuoteDetailUserCaseImpl): QuoteDetailUserCase

    companion object {
        @Provides
        fun provideQuoteService(retrofit: Retrofit): QuoteService =
            retrofit.create(QuoteService::class.java)
    }
}