package com.example.animalsworldapp.domain.usecases.forests

import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.ForestDomain

interface FetchLimitForestUseCase {
    suspend fun invoke(limit: Int): Result<List<ForestDomain>>
}