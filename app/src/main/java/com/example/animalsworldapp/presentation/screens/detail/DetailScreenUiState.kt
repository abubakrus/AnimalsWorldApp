package com.example.animalsworldapp.presentation.screens.detail



sealed class DetailScreenUiState {

    data object Initial : DetailScreenUiState()

    data object Loading : DetailScreenUiState()

    data class Error(val message: String) : DetailScreenUiState()

    data class Content(
        val contentType: ContentType,
    ) : DetailScreenUiState()
}