package com.example.animalsworldapp.domain.usecases.signup

import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.UsersDomain


interface SignUpUseCase {
    suspend operator fun invoke(
        name: String,
        lastName: String,
        email: String,
        password: String
    ): Result<UsersDomain>

}