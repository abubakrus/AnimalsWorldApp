package com.example.animalsworldapp.domain.usecases.mountain_usecase

import com.example.animalsworldapp.domain.models.MountainDomain

interface FetchAllMountainUseCase {
    suspend operator fun invoke(): List<MountainDomain>
}