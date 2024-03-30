package com.example.animalsworldapp.data.cloud.service

import com.example.animalsworldapp.data.cloud.models.users.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Query
import javax.annotation.concurrent.Immutable


@Immutable
interface UsersService {
    @GET("Users")
    suspend fun fetchUserById(
        @Query("where") params: String
    ): UsersResponse

}