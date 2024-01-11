package com.example.animalsworldapp.domain.repositories

import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.ForestDomain

interface ForestRepository {

    suspend fun fetchForestById(id: String): Result<ForestDomain>

    suspend fun fetchAllForest(): Result<List<ForestDomain>>

    suspend fun getLimitedData(limit: Int): Result<List<ForestDomain>>

    suspend fun deleteForestById(id: String)

    suspend fun updateForest(updateFauna: ForestDomain): Result<ForestDomain>

}