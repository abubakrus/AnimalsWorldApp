package com.example.animalsworldapp.presentation.screens.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.animalsworldapp.domain.usecases.user.FetchCurrentUserUseCase
import com.example.animalsworldapp.domain.usecases.user.FetchUserByIdUseCase
import com.example.animalsworldapp.presentation.extensions.createMutableSharedFlowAsSingleLiveEvent
import com.example.animalsworldapp.presentation.manager.toast.ShowToastUseCase
import com.example.animalsworldapp.presentation.models.toUser
import com.example.animalsworldapp.presentation.screens.edit_profile.EDIT_PROFILE_ROUTE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val showToast: ShowToastUseCase,
    private val fetchUserByIdUseCase: FetchUserByIdUseCase,
    private val fetchCurrentUserUseCase: FetchCurrentUserUseCase
) : ViewModel() {


    private val _uiState = MutableStateFlow<ProfileUiState>(ProfileUiState.Initial)
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

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

    init {
        try {
            val user = fetchCurrentUserUseCase().toUser()
            _uiState.tryEmit(ProfileUiState.Content(user))
            Log.i("Abubakir", "name = ${user.name.toString()}")
        } catch (e: Throwable) {
            val errorState = ProfileUiState.Error(e.stackTraceToString())
            _uiState.tryEmit(errorState)
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