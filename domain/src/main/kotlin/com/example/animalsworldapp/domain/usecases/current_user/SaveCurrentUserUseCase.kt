package com.example.animalsworldapp.domain.usecases.current_user

import com.example.animalsworldapp.domain.models.UsersDomain
import com.example.animalsworldapp.domain.repositories.CurrentUserRepository

interface SaveCurrentUserUseCase {
    operator fun invoke(user: UsersDomain)
}

class SaveCurrentUserUseCaseImpl constructor(
    private val repository: CurrentUserRepository
) : SaveCurrentUserUseCase {

    override fun invoke(user: UsersDomain) {
        repository.saveCurrentUser(user = user)
    }
}