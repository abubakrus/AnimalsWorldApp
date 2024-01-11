package com.example.animalsworldapp.presentation.screens.edit_profile


sealed class EditProfileUiState {

    data object Initial : EditProfileUiState()

    data object Loading : EditProfileUiState()

    data class Error(val message: String) : EditProfileUiState()

    data class Content(
        val name: String,
        val lastName: String,
        val nickName: String,
        val contackWithMe: String,
        val about: String,
        val location:String
        ) : EditProfileUiState()
}