package com.akshar.mindguardian.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.akshar.mindguardian.data.local.entities.MoodEntry
import kotlinx.coroutines.flow.Flow

// data/local/dao/MoodDao.kt
@Dao
interface MoodDao {
    @Insert
    suspend fun insertMoodEntry(moodEntry: MoodEntry)

    @Query("SELECT * FROM mood_entries ORDER BY date DESC")
    fun getAllEntries(): Flow<List<MoodEntry>> // Observe changes in real-time
}