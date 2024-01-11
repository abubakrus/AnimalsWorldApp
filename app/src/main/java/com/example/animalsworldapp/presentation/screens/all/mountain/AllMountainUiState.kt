package com.example.animalsworldapp.presentation.screens.all.mountain

import com.example.animalsworldapp.presentation.models.Mountain

sealed class AllMountainUiState {

    data object Loading : AllMountainUiState()

    data class Loaded(
        val mountain: List<Mountain>
    ) : AllMountainUiState()

    data class Error(
        val error: String
    ): AllMountainUiState()

}
