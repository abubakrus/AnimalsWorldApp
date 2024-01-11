package com.example.animalsworldapp.domain.usecases.forests

import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.ForestDomain

interface FetchForestByIdUseCase {
    suspend fun invoke(id: String): Result<ForestDomain>
}