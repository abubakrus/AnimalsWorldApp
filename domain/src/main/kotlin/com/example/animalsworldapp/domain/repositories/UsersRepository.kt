package com.example.animalsworldapp.domain.repositories

import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.UsersDomain

interface UsersRepository {

    suspend fun fetchUserById(id: String): Result<UsersDomain>

    suspend fun deleteUserById(id: String)

    suspend fun updateUser(updateUser: UsersDomain): kotlin.Result<UsersDomain>
}