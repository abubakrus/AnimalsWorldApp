package com.example.animalsworldapp.presentation.screens.auth.login

data class LoginUiState(
    val email: String = String(),
    val password: String = String(),
    val isAuthentication: Boolean = false,
    val errorMessage: String? = null,
    val isSuccessesAuth: Boolean = false
)
