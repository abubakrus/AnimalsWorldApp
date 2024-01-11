package com.example.animalsworldapp.data.cloud.service

import com.example.animalsworldapp.data.cloud.models.flora.FloraResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface FloraService {
    @GET("Mountain")
    suspend fun getLimitedData(
        @Query("limit") limit: Int
    ): FloraResponse

    @GET("Mountain")
    suspend fun fetchFloraById(
        @Query("where") params: String
    ): FloraResponse

    @GET("Mountain")
    suspend fun fetchAllFlora(): FloraResponse
}