package com.example.animalsworldapp.presentation.screens.profile

import androidx.lifecycle.ViewModel
import com.example.animalsworldapp.presentation.extensions.createMutableSharedFlowAsSingleLiveEvent
import com.example.animalsworldapp.presentation.manager.toast.ShowToastUseCase
import com.example.animalsworldapp.presentation.screens.edit_profile.EDIT_PROFILE_ROUTE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val showToast: ShowToastUseCase
) : ViewModel() {
    private val _navCommandFlow = createMutableSharedFlowAsSingleLiveEvent<String>()
    val navCommandFlow: SharedFlow<String> = _navCommandFlow.asSharedFlow()

    fun onEvent(event: ProfileEvent) {
        when (event) {
            is ProfileEvent.OnEditProfile -> navigateToEditProfileScreen()
            is ProfileEvent.OnEditUserType -> onEditUserType()
            is ProfileEvent.OnEditLanguage -> onEditLanguage()
            is ProfileEvent.OnEditChangeTheme -> {}
        }
    }

    private fun navigateToEditProfileScreen() {
        _navCommandFlow.tryEmit(EDIT_PROFILE_ROUTE)
    }

    private fun onEditLanguage() {
        showToast.showToast(message = "Сейчас эта функция не доступна")
        return
    }

    private fun onEditUserType() {
        showToast.showToast(message = "Сейчас эта функция не доступна")
        return
    }
}