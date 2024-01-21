package com.example.animalsworldapp.domain.usecases.fauna_usecase

import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.FaunaDomain
import com.example.animalsworldapp.domain.repositories.FaunaRepository

class SearchByQueryFaunaUseCaseImpl constructor(
    private val repository: FaunaRepository
) : SearchByQueryFaunaUseCase {
    override suspend fun searchByQuery(query: String): Result<List<FaunaDomain>> {
        return repository.searchByQuery(query)
    }
}