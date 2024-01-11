package com.example.animalsworldapp.presentation.screens.all.mountain

import com.example.animalsworldapp.presentation.navigation.destination.Destination

object AllMountainDestination : Destination {
    override fun route(): String = "all_mountain_screen"

    override fun routeWithArgs(): String = route()
}