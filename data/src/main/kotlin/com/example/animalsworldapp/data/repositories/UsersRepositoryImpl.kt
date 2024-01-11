package com.example.animalsworldapp.data.repositories

import com.example.animalsworldapp.data.cloud.mappers.toDomain
import com.example.animalsworldapp.data.cloud.service.UsersService
import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.UsersDomain
import com.example.animalsworldapp.domain.repositories.UsersRepository
import java.util.concurrent.CancellationException
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val service: UsersService
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
}
