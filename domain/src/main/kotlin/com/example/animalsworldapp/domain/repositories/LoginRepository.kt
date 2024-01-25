package com.example.animalsworldapp.domain.repositories

import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.CreateResponseDomain
import com.example.animalsworldapp.domain.models.UsersDomain


interface LoginRepository {
    suspend fun signIn(email: String, password: String): Result<UsersDomain>

    suspend fun signUp(
        name: String,
        lastName: String,
        email: String,
        password: String,
        nickName: String,
        location: String,
        aboutYou: String,
        ): Result<CreateResponseDomain>
}