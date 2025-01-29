package com.akshar.mindguardian.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mood_entries")
data class MoodEntry(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val date: Long = System.currentTimeMillis(), // Timestamp
    val journalText: String,                    // User's journal text
    val sentimentScore: Float                   // Sentiment score from DeepSeek API
)