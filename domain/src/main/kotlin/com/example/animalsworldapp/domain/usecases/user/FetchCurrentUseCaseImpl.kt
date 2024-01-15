package com.example.animalsworldapp.domain.usecases.user

import com.example.animalsworldapp.domain.models.UsersDomain
import com.example.animalsworldapp.domain.repositories.UsersRepository

class FetchCurrentUserUseCaseImpl constructor(
    private val repository: UsersRepository
) : FetchCurrentUserUseCase {
    override fun invoke(): UsersDomain {
        return repository.fetchCurrent()
    }
}