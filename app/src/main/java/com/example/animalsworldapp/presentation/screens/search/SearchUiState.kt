package com.example.animalsworldapp.presentation.screens.search

import com.example.animalsworldapp.presentation.models.Fauna
import com.example.animalsworldapp.presentation.models.Flora
import com.example.animalsworldapp.presentation.models.Forest
import com.example.animalsworldapp.presentation.models.Mountain

sealed class SearchUiState() {
    data object Initial : SearchUiState()

    data object Loading : SearchUiState()

    data class Error(val message: String) : SearchUiState()

    data class Content(

        val fauna: List<Fauna> = emptyList(),
        val flora: List<Flora> = emptyList(),
        val mountain: List<Mountain> = emptyList(),
        val forest: List<Forest> = emptyList(),
    ) : SearchUiState()
}