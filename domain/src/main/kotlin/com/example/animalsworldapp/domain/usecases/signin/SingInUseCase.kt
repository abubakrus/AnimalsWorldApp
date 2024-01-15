package com.example.animalsworldapp.domain.usecases.signin

import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.UsersDomain


interface SingInUseCase {
    suspend operator fun invoke(email: String, password: String): Result<UsersDomain>

}