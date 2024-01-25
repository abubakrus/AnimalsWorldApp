package com.example.animalsworldapp.data.repositories

import android.content.Context
import com.example.animalsworldapp.data.cloud.mappers.toDomain
import com.example.animalsworldapp.data.cloud.service.UsersService
import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.UsersDomain
import com.example.animalsworldapp.domain.repositories.UsersRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.concurrent.CancellationException
import javax.inject.Inject


private val SETTINGS_SHARED_PREF_NAME = "on_boarding_file"
private val IS_ON_BOARDING_PASSED_NAME = "is_on_boarding_passed"
private val CURRENT_USER_NAME = "CURRENT_USER_NAME"

class UsersRepositoryImpl @Inject constructor(
    private val service: UsersService,
    @ApplicationContext private val context: Context

) : UsersRepository {


    override suspend fun fetchUserById(id: String): Result<UsersDomain> {
        return try {
            val params = "{\"objectId\":\"$id\"}"
            val response = service.fetchUserById(params)
            val user = response.results.first().toDomain()
            Result.Success(data = user)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Result.Error(message = e.message ?: e.stackTraceToString())
        }
    }

    override suspend fun deleteUserById(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun updateUser(updateUser: UsersDomain): kotlin.Result<UsersDomain> {
        TODO("Not yet implemented")
    }
}
