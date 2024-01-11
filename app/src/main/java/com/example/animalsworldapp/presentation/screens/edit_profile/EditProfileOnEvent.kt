package com.example.animalsworldapp.presentation.screens.edit_profile

import android.graphics.Bitmap

sealed class EditProfileOnEvent {

    data object OnSaveClick : EditProfileOnEvent()

    data class OnNamedChanged(val value: String) : EditProfileOnEvent()

    data class OnLastNamedChanged(val value: String) : EditProfileOnEvent()

    data class OnAboutChanged(val value: String) : EditProfileOnEvent()

    data class OnNickNameChanged(val value: String) : EditProfileOnEvent()

    data class OnAvatarChanged(val bitmap: Bitmap) : EditProfileOnEvent()
}