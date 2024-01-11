package com.example.animalsworldapp.presentation.screens.splash

import com.example.animalsworldapp.presentation.navigation.destination.Destination

object SplashDestination : Destination {

    override fun route(): String = "splash_screen_route"

    override fun routeWithArgs(): String = route()

}