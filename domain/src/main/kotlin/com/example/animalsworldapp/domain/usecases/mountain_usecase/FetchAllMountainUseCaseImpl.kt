package com.example.animalsworldapp.domain.usecases.mountain_usecase

import com.example.animalsworldapp.domain.models.MountainDomain
import com.example.animalsworldapp.domain.repositories.MountainRepository
import com.example.animalsworldapp.domain.usecases.mountain_usecase.FetchAllMountainUseCase

class FetchAllMountainUseCaseImpl(
    private val repository: MountainRepository
) : FetchAllMountainUseCase {
    override suspend fun invoke(): List<MountainDomain> {
        val allMountain = repository.fetchAllMountain().data
        return allMountain ?: listOf()
    }
}