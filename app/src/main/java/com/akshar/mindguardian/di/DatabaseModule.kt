package com.akshar.mindguardian.di

import android.content.Context
import com.akshar.mindguardian.data.local.AppDatabase
import com.akshar.mindguardian.data.local.dao.MoodDao
import com.akshar.mindguardian.data.remote.api.DeepSeekApi
import com.akshar.mindguardian.data.repository.MoodRepositoryImpl
import com.akshar.mindguardian.domain.repository.MoodRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

// di/DatabaseModule.kt
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getDatabase(context)
    }

    @Provides
    fun provideMoodDao(appDatabase: AppDatabase): MoodDao {
        return appDatabase.moodDao()
    }
}