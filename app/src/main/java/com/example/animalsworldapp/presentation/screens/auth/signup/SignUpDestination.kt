package com.example.animalsworldapp.presentation.screens.auth.signup

import com.example.animalsworldapp.presentation.navigation.destination.Destination

object SignUpDestination : Destination {
    override fun route(): String = "signup_screen"

    override fun routeWithArgs(): String = route()
}