package com.akshar.mindguardian.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.akshar.mindguardian.data.local.dao.MoodDao
import com.akshar.mindguardian.data.local.entities.MoodEntry

// data/local/AppDatabase.kt
@Database(
    entities = [MoodEntry::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun moodDao(): MoodDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "mindguardian_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}