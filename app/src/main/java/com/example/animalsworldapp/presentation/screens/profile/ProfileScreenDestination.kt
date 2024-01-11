package com.example.animalsworldapp.presentation.screens.profile

import com.example.animalsworldapp.presentation.navigation.destination.Destination

object ProfileScreenDestination : Destination {
    override fun route(): String = "profile_screen"

    override fun routeWithArgs(): String = route()
}