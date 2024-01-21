package com.example.animalsworldapp.domain.repositories

import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.FaunaDomain


interface FaunaRepository {

    suspend fun fetchFaunaById(id: String): Result<FaunaDomain>

    suspend fun searchByQuery(query: String):  Result<List<FaunaDomain>>

    suspend fun fetchAllFauna(): Result<List<FaunaDomain>>

    suspend fun getLimitedData(limit: Int): Result<List<FaunaDomain>>

    suspend fun deleteFaunaById(id: String)

    suspend fun updateFauna(updateFauna: FaunaDomain): Result<FaunaDomain>
}