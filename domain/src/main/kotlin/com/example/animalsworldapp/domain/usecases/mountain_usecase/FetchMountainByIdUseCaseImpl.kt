package com.example.animalsworldapp.domain.usecases.mountain_usecase

import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.MountainDomain
import com.example.animalsworldapp.domain.repositories.MountainRepository
import com.example.animalsworldapp.domain.usecases.mountain_usecase.FetchMountainByIdUseCase

class FetchMountainByIdUseCaseImpl  constructor(
    private val repository: MountainRepository
) : FetchMountainByIdUseCase {
    override suspend fun fetchMountainById(id: String): Result<MountainDomain> {
        return repository.fetchMountainById(id)
    }
}