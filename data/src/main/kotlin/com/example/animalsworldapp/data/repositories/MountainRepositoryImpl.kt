package com.example.animalsworldapp.data.repositories

import com.example.animalsworldapp.data.cloud.service.MountainService
import android.util.Log
import com.example.animalsworldapp.data.cloud.mappers.toDomain
import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.MountainDomain
import com.example.animalsworldapp.domain.repositories.MountainRepository
import java.util.concurrent.CancellationException
import javax.inject.Inject

class MountainRepositoryImpl @Inject constructor(
    private val service: MountainService
) : MountainRepository {
    override suspend fun fetchMountainById(id: String): Result<MountainDomain> {
        return try {
            val params = "{\"objectId\":\"$id\"}"
            val response = service.fetchMountainById(params)
            val mountain = response.results.first().toDomain()
            Result.Success(data = mountain)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.e("Abubakir", e.stackTraceToString())
            Result.Error(message = e.message ?: e.stackTraceToString())
        }
    }

    override suspend fun fetchAllMountain(): Result<List<MountainDomain>> {
        return try {
            val mountainCloud = service.fetchAllMountain().results
            Result.Success(data = mountainCloud.map { it.toDomain() })

        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.e("Abubakir", e.stackTraceToString())
            Result.Error(message = e.message ?: e.stackTraceToString())
        }
    }

    override suspend fun getLimitedData(limit: Int): Result<List<MountainDomain>> {
        return try {
            val getLimited = service.getLimitedData(limit).results
            Result.Success(data = getLimited.map { it.toDomain() })
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.e("Animal", e.stackTraceToString())
            Result.Error(message = e.message ?: e.stackTraceToString())
        }
    }

    override suspend fun deleteMountainById(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun updateMountain(updateFauna: MountainDomain): Result<MountainDomain> {
        TODO("Not yet implemented")
    }
}