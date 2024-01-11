package com.example.animalsworldapp.presentation.screens.search

import com.example.animalsworldapp.presentation.models.Fauna
import com.example.animalsworldapp.presentation.models.Flora

data class SearchUiState(
    val query: String = "",
    val fauna: List<Fauna> = emptyList(),
    val flora: List<Flora> = emptyList(),
    val isLoading: Boolean = false
)