package com.example.animalsworldapp.domain.usecases.signin

import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.UsersDomain
import com.example.animalsworldapp.domain.repositories.LoginRepository
import java.util.regex.Pattern


class SingInUseCaseImpl constructor(
    private val repository: LoginRepository
) : SingInUseCase {


    override suspend fun invoke(
        email: String,
        password: String
    ): Result<UsersDomain> {
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

        return repository.signIn(
            email = email,
            password = password
        )
    }
}

internal fun String.isValidString(): Boolean {
    val emailPattern = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+"
    )
    return emailPattern.matcher(this).matches()

}