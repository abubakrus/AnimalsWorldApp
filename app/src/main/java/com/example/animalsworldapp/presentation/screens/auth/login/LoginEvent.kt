package com.example.animalsworldapp.presentation.screens.auth.login

sealed class LoginEvent {
    data class OnEmailChanged(val value: String) : LoginEvent()

    data class OnPasswordChanged(val value: String) : LoginEvent()

    data object OnSignUpClick : LoginEvent()

    data object OnLoginClick : LoginEvent()
}
