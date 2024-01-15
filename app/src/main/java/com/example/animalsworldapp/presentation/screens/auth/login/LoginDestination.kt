package com.example.animalsworldapp.presentation.screens.auth.login

import com.example.animalsworldapp.presentation.navigation.destination.Destination

object LoginDestination : Destination {
    override fun route(): String = "login_screen"

    override fun routeWithArgs(): String = route()
}