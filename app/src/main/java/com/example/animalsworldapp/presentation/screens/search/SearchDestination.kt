package com.example.animalsworldapp.presentation.screens.search

import com.example.animalsworldapp.presentation.navigation.destination.Destination

object SearchDestination : Destination {

    override fun route(): String = "search_screen"

    override fun routeWithArgs(): String = route()
}