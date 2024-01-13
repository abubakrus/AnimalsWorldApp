package com.example.animalsworldapp.presentation.screens.detail_fauna

import com.example.animalsworldapp.presentation.models.Fauna

sealed class DetailFaunaUiState {
    data object Initial : DetailFaunaUiState()

    data object Loading : DetailFaunaUiState()

    data class Error(val message: String) : DetailFaunaUiState()

    data class Content(val fauna: Fauna) : DetailFaunaUiState()

}