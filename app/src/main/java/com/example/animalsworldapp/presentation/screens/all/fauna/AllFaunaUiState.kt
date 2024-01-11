package com.example.animalsworldapp.presentation.screens.all.fauna

import com.example.animalsworldapp.presentation.models.Fauna

sealed class AllFaunaUiState{

    data object Loading:AllFaunaUiState()

    data class Loaded(
        val fauna: List<Fauna>
    ):AllFaunaUiState()

    data class Error(
        val error:String
    ):AllFaunaUiState()
}
