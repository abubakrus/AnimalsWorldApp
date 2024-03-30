package com.example.animalsworldapp.presentation.navigation.destination

import javax.annotation.concurrent.Immutable


@Immutable
interface Destination {

    fun route(): String
    fun routeWithArgs(): String
}


