package com.example.animalsworldapp.domain.usecases.mountain_usecase

import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.MountainDomain

interface FetchLimitMountainUseCase {
    suspend operator fun invoke(limit: Int): Result<List<MountainDomain>>
}