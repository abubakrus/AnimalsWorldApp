package com.example.animalsworldapp.data.cloud.service

import com.example.animalsworldapp.data.cloud.models.fauna.FaunaResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface FaunaService {
    @GET("Fauna")
    suspend fun getLimitedData(
        @Query("limit") limit: Int
    ): FaunaResponse

    @GET("Fauna")
    suspend fun fetchFaunaById(
        @Query("where") params: String
    ): FaunaResponse

    @GET("Fauna")
    suspend fun fetchAllFauna(): FaunaResponse
}