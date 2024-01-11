package com.example.animalsworldapp.domain.repositories

interface ShowedOnBoardingRepository {

    fun setOnBoardingShowed()

    fun isOnBoardingPassed(): Boolean

    fun clearOnBoarding()

}