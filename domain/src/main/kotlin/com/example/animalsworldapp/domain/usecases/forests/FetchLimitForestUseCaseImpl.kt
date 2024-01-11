package com.example.animalsworldapp.domain.usecases.forests

import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.ForestDomain
import com.example.animalsworldapp.domain.repositories.ForestRepository

class FetchLimitForestUseCaseImpl constructor(
    private val repository: ForestRepository
):FetchLimitForestUseCase {
    override suspend fun invoke(limit: Int): Result<List<ForestDomain>> {
        return repository.getLimitedData(limit)

    }
}