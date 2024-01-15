package com.example.animalsworldapp.data.cloud.service


import com.example.animalsworldapp.data.cloud.models.users.CreateResponse
import com.example.animalsworldapp.data.cloud.models.users.SignUpParams
import com.example.animalsworldapp.data.cloud.models.users.UsersResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginService {

    @GET("Users")
    suspend fun signIn(
        @Query("where") params: String
    ): Response<UsersResponse>


    @POST("Users")
    suspend fun signUp(
        @Body params: SignUpParams
    ): Response<CreateResponse>

}