package com.example.animalsworldapp.presentation.screens.profile

sealed class ProfileEvent {

    data object OnEditUserType : ProfileEvent()

    data object OnEditProfile : ProfileEvent()

    data object OnEditLanguage : ProfileEvent()

    data object OnEditChangeTheme : ProfileEvent()

}