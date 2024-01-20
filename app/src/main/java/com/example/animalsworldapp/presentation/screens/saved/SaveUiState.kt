package com.example.animalsworldapp.presentation.screens.saved

import com.example.animalsworldapp.presentation.models.Fauna
import com.example.animalsworldapp.presentation.models.Flora
import com.example.animalsworldapp.presentation.models.Mountain

sealed class SaveUiState {

    data object Loading : SaveUiState()

    data class Loaded(
        val fauna: List<Fauna>,
        val flora: List<Flora>,
        val mountain: List<Mountain>
    ) : SaveUiState()

    data class Error(
        val message: String
    ) : SaveUiState()

}