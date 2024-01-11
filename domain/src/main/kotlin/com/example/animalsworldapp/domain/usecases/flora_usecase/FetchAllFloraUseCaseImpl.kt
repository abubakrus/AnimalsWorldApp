package com.example.animalsworldapp.domain.usecases.flora_usecase

import com.example.animalsworldapp.domain.models.FloraDomain
import com.example.animalsworldapp.domain.repositories.FloraRepository
import com.example.animalsworldapp.domain.usecases.flora_usecase.FetchAllFloraUseCase

class FetchAllFloraUseCaseImpl constructor(
    private val repository: FloraRepository
) : FetchAllFloraUseCase {
    override suspend fun invoke(): List<FloraDomain> {
        val allFlora = repository.fetchAllFlora().data
        println("Flora" + allFlora?.size)
        return allFlora ?: listOf()
    }
}