package com.example.animalsworldapp.presentation.screens.onboarding

import com.example.animalsworldapp.presentation.navigation.destination.Destination


object OnBoardingDestination : Destination {

    override fun route(): String = "on_boarding_screen_route"

    override fun routeWithArgs(): String = route()
}