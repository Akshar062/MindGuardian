package com.akshar.mindguardian.di

import com.akshar.mindguardian.data.local.dao.MoodDao
import com.akshar.mindguardian.data.remote.api.DeepSeekApi
import com.akshar.mindguardian.data.repository.MoodRepositoryImpl
import com.akshar.mindguardian.domain.repository.MoodRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideMoodRepository(
        moodDao: MoodDao,
        deepSeekApi: DeepSeekApi
    ): MoodRepository {
        return MoodRepositoryImpl(moodDao, deepSeekApi)
    }
}