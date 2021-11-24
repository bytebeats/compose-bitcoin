package me.bytebeats.compose.bitcoin.retrofit

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Created by bytebeats on 2021/11/23 : 17:32
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    private const val BLOCKCHAIN_BASE_URL = "https://api.blockchain.info/"

    @Singleton
    @Provides
    fun provideRetrofitService(
        baseUrl: String,
        client: OkHttpClient,
        converterFactory: MoshiConverterFactory
    ): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl).client(client)
            .addConverterFactory(converterFactory).build()
    }

    @Provides
    fun provideBlockchainBaseUrl(): String = BLOCKCHAIN_BASE_URL

    @Singleton
    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
    }

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
    }

    @Singleton
    @Provides
    fun provideMoshiConverterFactory(): MoshiConverterFactory {
        return MoshiConverterFactory.create()
    }
}