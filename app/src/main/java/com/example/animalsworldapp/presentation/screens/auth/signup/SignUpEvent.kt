package com.example.animalsworldapp.presentation.screens.auth.signup

sealed class SignUpEvent {
    data class OnEmailChanged(val value: String) : SignUpEvent()

    data class OnNamedChanged(val value: String) : SignUpEvent()

    data class OnNickNamedChanged(val value: String) : SignUpEvent()


    data class OnAboutYouChanged(val value: String) : SignUpEvent()


    data class OnLocationChanged(val value: String) : SignUpEvent()


    data class OnLastNamedChanged(val value: String) : SignUpEvent()

    data class OnPasswordChanged(val value: String) : SignUpEvent()

    data object OnSignUpClick : SignUpEvent()

    data object OnLoginClick : SignUpEvent()
}
