package com.example.animalsworldapp.data.repositories

import android.util.Log
import com.example.animalsworldapp.data.cloud.mappers.toDomain
import com.example.animalsworldapp.data.cloud.service.FloraService
import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.FloraDomain
import com.example.animalsworldapp.domain.repositories.FloraRepository
import java.util.concurrent.CancellationException
import javax.inject.Inject

class FloraRepositoryImpl @Inject constructor(
    private val service: FloraService
) : FloraRepository {
    override suspend fun fetchFloraById(id: String): Result<FloraDomain> {
        return try {
            val params = "{\"objectId\":\"$id\"}"
            val response = service.fetchFloraById(params)
            val flora = response.results.first().toDomain()
            Result.Success(data = flora)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.e("FloraApp", e.stackTraceToString())
            Result.Error(message = e.message ?: e.stackTraceToString())
        }
    }

    override suspend fun fetchAllFlora(): Result<List<FloraDomain>> {
        return try {
            val floraClouds = service.fetchAllFlora().results
            Result.Success(data = floraClouds.map { it.toDomain() })
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.e("FloraApp", e.stackTraceToString())
            Result.Error(message = e.message ?: e.stackTraceToString())
        }
    }

    override suspend fun deleteFloraById(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun updateFlora(updateFlora: FloraDomain): Result<FloraDomain> {
        TODO("Not yet implemented")
    }
}