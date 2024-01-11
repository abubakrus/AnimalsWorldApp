package com.example.animalsworldapp.data.repositories

import android.util.Log
import com.example.animalsworldapp.data.cloud.mappers.toDomain
import com.example.animalsworldapp.data.cloud.service.ForestService
import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.ForestDomain
import com.example.animalsworldapp.domain.repositories.ForestRepository
import java.util.concurrent.CancellationException
import javax.inject.Inject

class ForestRepositoryImpl @Inject constructor(
    private val service: ForestService
) : ForestRepository {
    override suspend fun fetchForestById(id: String): Result<ForestDomain> {
        return try {
            val params = "{\"objectId\":\"$id\"}"
            val response = service.fetchForestById(params)
            val forest = response.results.first().toDomain()
            Result.Success(data = forest)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Result.Error(message = e.message ?: e.stackTraceToString())
        }
    }

    override suspend fun fetchAllForest(): Result<List<ForestDomain>> {
        return try {
            val allForests = service.fetchAllForest().results
            Result.Success(data = allForests.map { it.toDomain() })
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Result.Error(message = e.message ?: e.stackTraceToString())
        }
    }

    override suspend fun getLimitedData(limit: Int): Result<List<ForestDomain>> {
        return try {
            val getLimited = service.getLimitedData(limit).results
            Result.Success(data = getLimited.map { it.toDomain() })
        }catch (e:CancellationException){
            throw e
        }catch (e:Exception){
            Log.e("Animal", e.stackTraceToString())
            Result.Error(message = e.message ?: e.stackTraceToString())
        }
    }

    override suspend fun deleteForestById(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun updateForest(updateFauna: ForestDomain): Result<ForestDomain> {
        TODO("Not yet implemented")
    }
}