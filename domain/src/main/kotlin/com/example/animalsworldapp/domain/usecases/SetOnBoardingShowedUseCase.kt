package com.example.animalsworldapp.domain.usecases

import com.example.animalsworldapp.domain.repositories.ShowedOnBoardingRepository


interface SetOnBoardingShowedUseCase {
    operator fun invoke()
}

class SetOnBoardingShowedUseCaseImpl constructor(
    private val repository: ShowedOnBoardingRepository
) : SetOnBoardingShowedUseCase {
    override fun invoke() {
        repository.setOnBoardingShowed()
    }
}