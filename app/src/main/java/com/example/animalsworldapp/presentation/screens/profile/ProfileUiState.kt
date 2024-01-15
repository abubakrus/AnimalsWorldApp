package com.example.animalsworldapp.presentation.screens.profile

import com.example.animalsworldapp.domain.usecases.user.FetchUserByIdUseCase
import com.example.animalsworldapp.presentation.models.User

sealed class ProfileUiState {

    data object Initial : ProfileUiState()

    data object Loading : ProfileUiState()

    data class Error(val message: String) : ProfileUiState()

    data class Content(
        val user: User
    ) : ProfileUiState()

}