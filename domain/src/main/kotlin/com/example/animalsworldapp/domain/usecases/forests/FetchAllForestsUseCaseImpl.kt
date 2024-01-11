package com.example.animalsworldapp.domain.usecases.forests

import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.ForestDomain
import com.example.animalsworldapp.domain.repositories.ForestRepository

class FetchAllForestsUseCaseImpl constructor(
    private val repository: ForestRepository
):FetchAllForestsUseCase {
    override suspend fun invoke(): List<ForestDomain> {
        val allForest = repository.fetchAllForest().data
        return allForest ?: emptyList()
    }
}