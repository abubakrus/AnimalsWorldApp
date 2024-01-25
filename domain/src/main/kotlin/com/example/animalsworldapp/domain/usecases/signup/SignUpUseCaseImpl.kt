package com.example.animalsworldapp.domain.usecases.signup

import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.UsersDomain
import com.example.animalsworldapp.domain.repositories.LoginRepository
import com.example.animalsworldapp.domain.repositories.UsersRepository
import com.example.animalsworldapp.domain.usecases.signin.isValidString


class SignUpUseCaseImpl constructor(
    private val repository: LoginRepository,
    private val userRepository: UsersRepository
) : SignUpUseCase {
    override suspend fun invoke(
        name: String,
        lastName: String,
        email: String,
        password: String,
        nickName: String,
        location: String,
        aboutYou: String,
    ): Result<UsersDomain> {
        if (name.isEmpty()) {
            return Result.Error(message = "First fill in name!")
        }
        if (lastName.isEmpty()) {
            return Result.Error(message = "First fill in lastName!")
        }
        if (email.isEmpty()) {
            return Result.Error(message = "First fill in email!")
        }
        if (password.isEmpty()) {
            return Result.Error(message = "First fill in password!")
        }
        if (!email.isValidString()) {
            return Result.Error(message = "Incorrect fill email!")
        }
        if (password.length < 8) {
            return Result.Error(message = "Incorrect fill password!")
        }
        val response = repository.signUp(
            name = name,
            lastName = lastName,
            email = email,
            password = password,
            location = location,
            aboutYou = aboutYou,
            nickName = nickName,
        )
        return userRepository.fetchUserById(response.data?.id ?: String())
    }
}