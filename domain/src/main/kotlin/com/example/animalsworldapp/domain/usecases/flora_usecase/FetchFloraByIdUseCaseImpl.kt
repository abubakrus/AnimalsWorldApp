package com.example.animalsworldapp.domain.usecases.flora_usecase

import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.FloraDomain
import com.example.animalsworldapp.domain.repositories.FloraRepository
import com.example.animalsworldapp.domain.usecases.flora_usecase.FetchFloraByIdUseCase

class FetchFloraByIdUseCaseImpl constructor(
    private val repository: FloraRepository
) : FetchFloraByIdUseCase {
    override suspend fun fetchFloraById(id: String): Result<FloraDomain> {
        return repository.fetchFloraById(id)
    }
}