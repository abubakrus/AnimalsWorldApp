package com.example.animalsworldapp.data.repositories

import android.util.Log
import com.example.animalsworldapp.data.cloud.mappers.toDomain
import com.example.animalsworldapp.data.cloud.models.users.SignUpParams
import com.example.animalsworldapp.data.cloud.service.LoginService
import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.CreateResponseDomain
import com.example.animalsworldapp.domain.models.UsersDomain
import com.example.animalsworldapp.domain.repositories.LoginRepository
import java.util.concurrent.CancellationException
import javax.inject.Inject

const val DEFAULT_ERROR_MESSAGE = "Something went wrong"

class LoginRepositoryImpl @Inject constructor(
    private val service: LoginService
) : LoginRepository {

    override suspend fun signIn(
        email: String,
        password: String
    ): com.example.animalsworldapp.domain.common.Result<UsersDomain> {
        return try {
            val response = service.signIn("{\"email\":\"$email\", \"password\":\"$password\"}")
            val result = response.body()?.results!!.first()
            com.example.animalsworldapp.domain.common.Result.Success(data = result.toDomain())
        } catch (e: Throwable) {
            throw e
        } catch (e: Exception) {
            Log.e("SocialApp", e.stackTraceToString())
            com.example.animalsworldapp.domain.common.Result.Error(DEFAULT_ERROR_MESSAGE)
        }
    }

    override suspend fun signUp(
        name: String,
        lastName: String,
        email: String,
        password: String
    ): com.example.animalsworldapp.domain.common.Result<CreateResponseDomain> = try {
        val params = SignUpParams(
            name = name,
            lastName = lastName,
            email = email,
            password = password
        )
        val response = service.signUp(params)
        val result = response.body()!!
        com.example.animalsworldapp.domain.common.Result.Success(
            CreateResponseDomain(
                id = result.id,
            )
        )

    } catch (e: CancellationException) {
        throw e
    } catch (e: Exception) {
        Log.e("SocialApp", e.stackTraceToString())
        Result.Error(DEFAULT_ERROR_MESSAGE)
    }

}