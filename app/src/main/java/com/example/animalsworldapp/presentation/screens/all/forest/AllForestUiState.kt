package com.example.animalsworldapp.presentation.screens.all.forest

import com.example.animalsworldapp.presentation.models.Forest

sealed class AllForestUiState {

    data object Loading : AllForestUiState()

    data class Loaded(
        val forest: List<Forest>
    ) : AllForestUiState()

    data class Error(
        val error: String
    ) : AllForestUiState()

}
