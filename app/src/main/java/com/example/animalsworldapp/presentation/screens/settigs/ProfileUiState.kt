package com.example.animalsworldapp.presentation.screens.settigs

sealed class ProfileUiState {
    data object Initial : ProfileUiState()

    data object Loading : ProfileUiState()

    data class Error(val message: String) : ProfileUiState()

    data object Content : ProfileUiState()
}