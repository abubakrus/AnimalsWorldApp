package com.example.animalsworldapp.presentation.screens.detail

import com.example.animalsworldapp.presentation.models.Fauna
import com.example.animalsworldapp.presentation.models.Flora
import com.example.animalsworldapp.presentation.models.Forest
import com.example.animalsworldapp.presentation.models.Mountain


sealed class ContentType(
    val backgroundImage: String,
    val interestingFact: String?,
    val image: String,
    val location: String,
    val name: String,
    val about: String,
    val voice: String? = String(),
    val locationImage: String = String(),
    val animalsClasses: String = String()
) {

    data class FaunaContent(val fauna: Fauna) : ContentType(
        backgroundImage = fauna.backgroundImage,
        location = fauna.location,
        name = fauna.name,
        about = fauna.aboutFauna,
        voice = fauna.voice,
        image = fauna.image,
        interestingFact = fauna.interestingFact,
        locationImage = fauna.locationImage,
        animalsClasses = fauna.classes
    )

    data class FloraContent(val flora: Flora) : ContentType(
        backgroundImage = flora.backgroundImage,
        location = flora.interestingFact,
        name = flora.name,
        about = flora.aboutFlora,
        image = flora.image,
        interestingFact = flora.interestingFact
    )

    data class MountainContent(val mountain: Mountain) : ContentType(
        backgroundImage = mountain.backgroundImage,
        location = mountain.interestingFact,
        name = mountain.name,
        about = mountain.about,
        image = mountain.image,
        interestingFact = mountain.interestingFact
    )

    data class ForestContent(val forest: Forest) : ContentType(
        backgroundImage = forest.backgroundImage,
        location = forest.location,
        name = forest.name,
        about = forest.about,
        image = forest.image,
        interestingFact = forest.interestingFact
    )

    data object Unknown : ContentType(
        backgroundImage = String(),
        location = String(),
        name = String(),
        about = String(),
        image = String(),
        interestingFact = String()
    )
}
