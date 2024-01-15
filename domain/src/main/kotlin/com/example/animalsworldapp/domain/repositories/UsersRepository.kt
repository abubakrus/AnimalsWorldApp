package com.example.animalsworldapp.domain.repositories

import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.UsersDomain

interface UsersRepository {
    suspend fun fetchUserById(id: String): Result<UsersDomain>
    fun fetchCurrent(): UsersDomain
}