package com.example.animalsworldapp.domain.usecases.flora_usecase

import com.example.animalsworldapp.domain.models.FloraDomain

interface FetchAllFloraUseCase {
    suspend operator fun invoke():List<FloraDomain>
}