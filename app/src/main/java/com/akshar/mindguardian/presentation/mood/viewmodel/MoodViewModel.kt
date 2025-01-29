package com.akshar.mindguardian.presentation.mood.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akshar.mindguardian.data.local.entities.MoodEntry
import com.akshar.mindguardian.domain.repository.MoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

// presentation/mood/viewmodel/MoodViewModel.kt
@HiltViewModel
class MoodViewModel @Inject constructor(
    private val moodRepository: MoodRepository
) : ViewModel() {

    val moodEntries: Flow<List<MoodEntry>> = moodRepository.getAllEntries()

    fun analyzeAndSaveMood(text: String) {
        viewModelScope.launch {
            moodRepository.analyzeAndSaveMood(text)
        }
    }
}