package com.example.animalsworldapp.domain.usecases.fauna_usecase

import com.example.animalsworldapp.domain.models.FaunaDomain

interface FetchAllFaunaUseCase {
    suspend operator fun invoke(): List<FaunaDomain>
}
