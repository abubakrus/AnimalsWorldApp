package com.example.animalsworldapp.presentation.screens.settigs

sealed class ProfileEvent {

    data object OnEditUserType : ProfileEvent()

    data object OnEditLanguage : ProfileEvent()

    data object OnEditChangeTheme : ProfileEvent()

}