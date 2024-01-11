package com.example.animalsworldapp.domain.usecases.fauna_usecase

import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.FaunaDomain
import com.example.animalsworldapp.domain.repositories.FaunaRepository
import com.example.animalsworldapp.domain.usecases.fauna_usecase.FetchFaunaByIdUseCase

class FetchFaunaByIdUseCaseImpl constructor(
    private val repository: FaunaRepository
) : FetchFaunaByIdUseCase {
    override suspend fun fetchFaunaById(id: String): Result<FaunaDomain> {
        return repository.fetchFaunaById(id)
    }
}