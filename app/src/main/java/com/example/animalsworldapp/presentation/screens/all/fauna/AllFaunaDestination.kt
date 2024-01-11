package com.example.animalsworldapp.presentation.screens.all.fauna

import com.example.animalsworldapp.presentation.navigation.destination.Destination

object AllFaunaDestination : Destination {
    override fun route(): String = "all_fauna_screen"

    override fun routeWithArgs(): String = route()
}