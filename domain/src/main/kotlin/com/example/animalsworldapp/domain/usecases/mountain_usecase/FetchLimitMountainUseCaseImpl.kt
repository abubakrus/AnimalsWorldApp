package com.example.animalsworldapp.domain.usecases.mountain_usecase

import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.MountainDomain
import com.example.animalsworldapp.domain.repositories.MountainRepository

class FetchLimitMountainUseCaseImpl constructor(
    private val repository: MountainRepository
) : FetchLimitMountainUseCase {
    override suspend fun invoke(limit: Int): Result<List<MountainDomain>> {
        return repository.getLimitedData(limit)
    }
}