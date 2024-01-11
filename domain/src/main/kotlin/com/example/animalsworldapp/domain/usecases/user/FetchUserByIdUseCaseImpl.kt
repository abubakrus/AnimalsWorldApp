package com.example.animalsworldapp.domain.usecases.user

import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.UsersDomain
import com.example.animalsworldapp.domain.repositories.UsersRepository

class FetchUserByIdUseCaseImpl constructor(
    private val repository: UsersRepository
):FetchUserByIdUseCase {
    override suspend fun fetchUserByIdUseCase(id: String): Result<UsersDomain> {
        return repository.fetchUserById(id)
    }
}