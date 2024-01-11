package com.example.animalsworldapp.data.cloud.service

import com.example.animalsworldapp.data.cloud.models.mountain.MountainResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MountainService {
    @GET("Mountain")
    suspend fun getLimitedData(
        @Query("limit") limit: Int
    ): MountainResponse

    @GET("Mountain")
    suspend fun fetchMountainById(
        @Query("where") params: String
    ): MountainResponse

    @GET("Mountain")
    suspend fun fetchAllMountain(): MountainResponse
}