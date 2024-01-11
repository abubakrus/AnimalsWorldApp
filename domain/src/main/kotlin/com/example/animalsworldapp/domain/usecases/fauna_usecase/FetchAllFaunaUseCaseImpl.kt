package com.example.animalsworldapp.domain.usecases.fauna_usecase

import com.example.animalsworldapp.domain.models.FaunaDomain
import com.example.animalsworldapp.domain.repositories.FaunaRepository
import com.example.animalsworldapp.domain.usecases.fauna_usecase.FetchAllFaunaUseCase

class FetchAllFaunaUseCaseImpl  constructor(
    private val faunaRepository: FaunaRepository,
    ) : FetchAllFaunaUseCase {
    override suspend fun invoke(): List<FaunaDomain> {
        val allFauna = faunaRepository.fetchAllFauna().data
        return allFauna ?: listOf()
    }
}