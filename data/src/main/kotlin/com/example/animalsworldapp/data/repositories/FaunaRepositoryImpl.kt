package com.example.animalsworldapp.data.repositories

import android.util.Log
import com.example.animalsworldapp.data.cloud.mappers.toDomain
import com.example.animalsworldapp.data.cloud.service.FaunaService
import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.FaunaDomain
import com.example.animalsworldapp.domain.repositories.FaunaRepository
import java.util.concurrent.CancellationException
import javax.inject.Inject

class FaunaRepositoryImpl @Inject constructor(
    private val service: FaunaService
) : FaunaRepository {
    override suspend fun fetchFaunaById(id: String): Result<FaunaDomain> {
        return try {
            val params = "{\"objectId\":\"$id\"}"
            val response = service.fetchFaunaById(params)
            val fauna = response.results.first().toDomain()
            Result.Success(data = fauna)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.e("FaunaApp", e.stackTraceToString())
            Result.Error(message = e.message ?: e.stackTraceToString())
        }
    }

    override suspend fun searchByQuery(query: String): Result<List<FaunaDomain>> {
        return try {
            val params = "{\"name\":\"$query\"}"
            val response = service.searchByQuery(params)
            val result = response.results
            Result.Success(data = result.map { it.toDomain() })
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.e("FaunaApp", e.stackTraceToString())
            Result.Error(message = e.message ?: e.stackTraceToString())
        }
    }

    override suspend fun fetchAllFauna(): Result<List<FaunaDomain>> {
        return try {
            val faunaClouds = service.fetchAllFauna().results
            Result.Success(data = faunaClouds.map { it.toDomain() })
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.e("Social", e.stackTraceToString())
            Result.Error(message = e.message ?: e.stackTraceToString())
        }
    }

    override suspend fun getLimitedData(limit: Int): Result<List<FaunaDomain>> {
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

    override suspend fun deleteFaunaById(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun updateFauna(updateFauna: FaunaDomain): Result<FaunaDomain> {
        TODO("Not yet implemented")
    }
}