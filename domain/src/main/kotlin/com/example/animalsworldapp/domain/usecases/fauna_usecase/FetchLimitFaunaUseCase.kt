package com.example.animalsworldapp.domain.usecases.fauna_usecase

import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.FaunaDomain

interface FetchLimitFaunaUseCase {
    suspend operator fun invoke(limit: Int): Result<List<FaunaDomain>>
}