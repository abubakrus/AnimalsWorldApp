package com.example.animalsworldapp.presentation.screens.auth.signup

data class SignUpUiState (
    val name:String = String(),
    val lastName:String = String(),
    val email:String = String(),
    val password:String = String(),
    val isAuthentication:Boolean=false,
    val errorMessage:String? = null,
    val isSuccessesAuth:Boolean =false
)