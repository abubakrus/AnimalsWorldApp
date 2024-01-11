package com.example.animalsworldapp.domain.usecases.fauna_usecase

import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.FaunaDomain
import com.example.animalsworldapp.domain.repositories.FaunaRepository

class FetchLimitFaunaUseCaseImpl(
    private val repository: FaunaRepository
) : FetchLimitFaunaUseCase {
    override suspend fun invoke(limit: Int): Result<List<FaunaDomain>> {
        return repository.getLimitedData(limit)
    }
}