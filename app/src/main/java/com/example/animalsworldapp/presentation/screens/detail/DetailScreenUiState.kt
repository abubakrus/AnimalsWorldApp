package com.example.animalsworldapp.presentation.screens.detail

import com.example.animalsworldapp.presentation.models.Fauna
import com.example.animalsworldapp.presentation.models.Flora
import com.example.animalsworldapp.presentation.models.Forest
import com.example.animalsworldapp.presentation.models.Mountain

sealed class ContentType(
    val backgroundImage: String,
    val location: String,
    val name: String,
    val about: String,
    val voice: String? = String()
) {

    data class FaunaContent(val fauna: Fauna) : ContentType(
        backgroundImage = fauna.backgroundImage,
        location = fauna.location,
        name = fauna.name,
        about = fauna.aboutFauna,
        voice = fauna.voice
    )

    data class FloraContent(val flora: Flora) : ContentType(
        backgroundImage = flora.backgroundImage,
        location = flora.interestingFact,
        name = flora.name,
        about = flora.aboutFlora
    )

    data class MountainContent(val mountain: Mountain) : ContentType(
        backgroundImage = mountain.backgroundImage,
        location = mountain.interestingFact,
        name = mountain.name,
        about = mountain.about
    )

    data class ForestContent(val forest: Forest) : ContentType(
        backgroundImage = forest.backgroundImage,
        location = forest.interestingFact,
        name = forest.name,
        about = forest.about
    )

    data object Unknown : ContentType(
        backgroundImage = String(),
        location = String(),
        name = String(),
        about = String(),
    )
}

sealed class DetailScreenUiState {

    data object Initial : DetailScreenUiState()

    data object Loading : DetailScreenUiState()

    data class Error(val message: String) : DetailScreenUiState()

    data class Content(
        val contentType: ContentType
    ) : DetailScreenUiState()
}