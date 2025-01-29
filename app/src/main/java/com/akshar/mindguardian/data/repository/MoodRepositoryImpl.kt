package com.akshar.mindguardian.data.repository

import com.akshar.mindguardian.data.local.dao.MoodDao
import com.akshar.mindguardian.data.local.entities.MoodEntry
import com.akshar.mindguardian.data.remote.api.DeepSeekApi
import com.akshar.mindguardian.data.remote.api.SentimentRequest
import com.akshar.mindguardian.domain.repository.MoodRepository
import kotlinx.coroutines.flow.Flow

// data/repository/MoodRepositoryImpl.kt
class MoodRepositoryImpl(
    private val moodDao: MoodDao,
    private val deepSeekApi: DeepSeekApi
) : MoodRepository {

    override fun getAllEntries(): Flow<List<MoodEntry>> {
        return moodDao.getAllEntries()
    }

    override suspend fun analyzeAndSaveMood(text: String) {
        // Step 1: Call DeepSeek API for sentiment analysis
        val sentimentScore = deepSeekApi.analyzeSentiment(
            apiKey = "YOUR_DEEPSEEK_API_KEY",
            request = SentimentRequest(text)
        ).score

        // Step 2: Save to Room
        moodDao.insertMoodEntry(
            MoodEntry(
                journalText = text,
                sentimentScore = sentimentScore
            )
        )
    }
}