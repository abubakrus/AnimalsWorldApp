package com.example.animalsworldapp.domain.usecases

import com.example.animalsworldapp.domain.repositories.ShowedOnBoardingRepository


interface ShouldOnBoardingPassedUseCase {
    operator fun invoke(): Boolean
}

class ShouldOnBoardingPassedUseCaseImpl constructor(
    private val repository: ShowedOnBoardingRepository
) : ShouldOnBoardingPassedUseCase {
    override fun invoke(): Boolean {
        return repository.isOnBoardingPassed()
    }
}