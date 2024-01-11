package com.example.animalsworldapp.domain.usecases.flora_usecase

import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.FloraDomain

interface FetchFloraByIdUseCase {
    suspend fun fetchFloraById(id: String): Result<FloraDomain>
}