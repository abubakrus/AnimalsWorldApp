package com.example.animalsworldapp.domain.usecases.forests

import com.example.animalsworldapp.domain.models.ForestDomain

interface FetchAllForestsUseCase {
    suspend operator fun invoke(): List<ForestDomain>
}