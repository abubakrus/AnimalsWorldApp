package com.example.animalsworldapp.domain.usecases

import com.example.animalsworldapp.domain.models.FaunaDomain

interface SearchByQueryUseCase {
    suspend fun searchByQuery(query: String):List<FaunaDomain>
}