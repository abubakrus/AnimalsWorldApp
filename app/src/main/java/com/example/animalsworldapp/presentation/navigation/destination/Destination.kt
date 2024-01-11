package com.example.animalsworldapp.presentation.navigation.destination

interface Destination {
    fun route(): String

    fun routeWithArgs(): String
}


