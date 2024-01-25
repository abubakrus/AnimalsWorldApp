package com.example.animalsworldapp.domain.usecases.user

import com.example.animalsworldapp.domain.models.UsersDomain

    
interface FetchCurrentUserUseCase {
    operator fun invoke(): UsersDomain
}

