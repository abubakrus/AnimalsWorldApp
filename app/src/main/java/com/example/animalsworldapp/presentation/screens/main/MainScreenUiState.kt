package com.example.animalsworldapp.presentation.screens.main

import com.example.animalsworldapp.presentation.models.Fauna
import com.example.animalsworldapp.presentation.models.Flora
import com.example.animalsworldapp.presentation.models.Forest
import com.example.animalsworldapp.presentation.models.Mountain

sealed class MainScreenUiState {

    object Loading : MainScreenUiState()

    data class Loaded(
        val fauna: List<Fauna>,
        val flora: List<Flora>,
        val mountain: List<Mountain>,
        val forest: List<Forest>
    ) : MainScreenUiState()

    data class Error(
        val message: String
    ) : MainScreenUiState()
}