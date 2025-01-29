package com.akshar.mindguardian.di

import com.akshar.mindguardian.data.remote.api.DeepSeekApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// di/NetworkModule.kt
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideDeepSeekApi(): DeepSeekApi {
        return Retrofit.Builder()
            .baseUrl("https://api.deepseek.com/") // Replace with actual base URL
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                    .build()
            )
            .build()
            .create(DeepSeekApi::class.java)
    }
}