package com.example.animalsworldapp.domain.usecases.forests

import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.ForestDomain
import com.example.animalsworldapp.domain.repositories.ForestRepository

class FetchForestByIdUseCaseImpl constructor(
    private val repository: ForestRepository
) : FetchForestByIdUseCase {
    override suspend fun invoke(id: String): Result<ForestDomain> {
        return repository.fetchForestById(id)
    }
}