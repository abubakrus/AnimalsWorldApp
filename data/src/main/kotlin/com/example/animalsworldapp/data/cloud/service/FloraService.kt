package com.example.animalsworldapp.data.cloud.service

import com.example.animalsworldapp.data.cloud.models.flora.FloraResponse
import retrofit2.http.GET
import retrofit2.http.Query
import javax.annotation.concurrent.Immutable


@Immutable
interface FloraService {
    @GET("Flora")
    suspend fun getLimitedData(
        @Query("limit") limit: Int
    ): FloraResponse

    @GET("Flora")
    suspend fun fetchFloraById(
        @Query("where") params: String
    ): FloraResponse

    @GET("Flora")
    suspend fun fetchAllFlora(): FloraResponse
}