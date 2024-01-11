package com.example.animalsworldapp.presentation.screens.detail

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.animalsworldapp.presentation.navigation.destination.Destination

internal const val TYPE_ARGUMENT_KEY = "type_key"
internal const val ID_ARGUMENT_KEY = "id_key"

object DetailDestination : Destination {

    override fun route(): String = "detail_screen"

    override fun routeWithArgs(): String = "${route()}/{$TYPE_ARGUMENT_KEY}/{$ID_ARGUMENT_KEY}"

    val arguments = listOf(
        navArgument(TYPE_ARGUMENT_KEY) { type = NavType.IntType },
        navArgument(ID_ARGUMENT_KEY) { type = NavType.StringType },
    )
}