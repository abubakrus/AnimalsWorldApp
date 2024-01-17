package com.example.animalsworldapp.presentation.screens.detail.models


sealed class DetailTab(
) {
    data class Image(
        val image: String
    ) : DetailTab()

    data class BackgroundImage(
        val image: String
    ) : DetailTab()
}