package com.example.animalsworldapp.presentation.screens.search

import com.example.animalsworldapp.presentation.screens.detail.ContentType

//sealed class SearchUiState() {
//
//    data object Initial : SearchUiState()
//
//    data object Loading : SearchUiState()
//
//    data class Error(val message: String) : SearchUiState()
//
//    data class Content(
//
//        val fauna: List<Fauna> = emptyList(),
//        val flora: List<Flora> = emptyList(),
//        val mountain: List<Mountain> = emptyList(),
//        val forest: List<Forest> = emptyList(),
//    ) : SearchUiState()
//}

data class SearchUiState(
    val query: String = "",
    val contentType: List<ContentType> = emptyList(),
    val isLoading: Boolean = false
)