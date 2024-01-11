package com.example.animalsworldapp.presentation.screens.all.forest

import com.example.animalsworldapp.presentation.navigation.destination.Destination

object AllForestDestination : Destination {
    override fun route(): String = "all_forest_screen"

    override fun routeWithArgs(): String = route()
}