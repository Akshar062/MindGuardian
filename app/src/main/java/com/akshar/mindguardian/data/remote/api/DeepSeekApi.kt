package com.akshar.mindguardian.data.remote.api

import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

// data/remote/api/DeepSeekApi.kt
interface DeepSeekApi {
    @POST("sentiment")
    suspend fun analyzeSentiment(
        @Header("Authorization") apiKey: String,
        @Body request: SentimentRequest
    ): SentimentResponse
}

data class SentimentRequest(val text: String)
data class SentimentResponse(val score: Float)