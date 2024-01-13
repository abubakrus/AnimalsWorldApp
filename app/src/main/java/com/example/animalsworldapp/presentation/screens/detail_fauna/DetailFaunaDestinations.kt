package com.example.animalsworldapp.presentation.screens.detail_fauna

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.animalsworldapp.presentation.navigation.destination.Destination

object DetailFaunaDestinations : Destination {
    override fun route(): String = "detail_fauna_destinations"

    override fun routeWithArgs(): String = "${route()}/$faunaId"

    val faunaId = "faunaIdKey"

    val arguments = listOf(navArgument(faunaId) { type = NavType.IntType })

}