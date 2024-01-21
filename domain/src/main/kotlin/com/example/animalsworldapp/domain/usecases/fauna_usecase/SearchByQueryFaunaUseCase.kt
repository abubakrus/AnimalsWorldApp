package com.example.animalsworldapp.domain.usecases.fauna_usecase

import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.FaunaDomain

interface SearchByQueryFaunaUseCase {
    suspend fun searchByQuery(query: String): Result<List<FaunaDomain>>

}