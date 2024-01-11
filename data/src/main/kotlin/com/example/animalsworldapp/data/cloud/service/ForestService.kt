package com.example.animalsworldapp.data.cloud.service

import com.example.animalsworldapp.data.cloud.models.forests.ForestsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ForestService {
    @GET("Forest")
    suspend fun getLimitedData(
        @Query("limit") limit: Int
    ): ForestsResponse

    @GET("Forest")
    suspend fun fetchForestById(
        @Query("where") params: String
    ): ForestsResponse

    @GET("Forest")
    suspend fun fetchAllForest(): ForestsResponse
}


