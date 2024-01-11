package com.example.animalsworldapp.domain.usecases.user

import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.UsersDomain

interface FetchUserByIdUseCase {
    suspend fun fetchUserByIdUseCase(id: String): Result<UsersDomain>

}