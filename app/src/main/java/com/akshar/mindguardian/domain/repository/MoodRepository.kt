package com.akshar.mindguardian.domain.repository

import com.akshar.mindguardian.data.local.entities.MoodEntry
import kotlinx.coroutines.flow.Flow

// domain/repository/MoodRepository.kt
interface MoodRepository {
    fun getAllEntries(): Flow<List<MoodEntry>>
    suspend fun analyzeAndSaveMood(text: String)
}