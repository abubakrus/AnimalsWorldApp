package com.example.animalsworldapp.domain.usecases.current_user

import com.example.animalsworldapp.domain.models.UsersDomain
import com.example.animalsworldapp.domain.repositories.CurrentUserRepository

interface FetchCurrentUserUseCase {
    operator fun invoke(): UsersDomain
}

class FetchCurrentUserUseCaseImpl constructor(
    private val repository: CurrentUserRepository
) : FetchCurrentUserUseCase {
    override fun invoke(): UsersDomain {
        return repository.fetchCurrentUser()
    }
}