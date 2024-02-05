package com.example.animalsworldapp.presentation.screens.auth.signup

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.usecases.current_user.SaveCurrentUserUseCase
import com.example.animalsworldapp.domain.usecases.signup.SignUpUseCase
import com.example.animalsworldapp.presentation.extensions.createMutableSharedFlowAsSingleLiveEvent
import com.example.animalsworldapp.presentation.manager.NavigatorManager
import com.example.animalsworldapp.presentation.manager.toast.ShowToastUseCase
import com.example.animalsworldapp.presentation.navigation.nav_graph.MAIN_NAV_GRAPH_ROUTE
import com.example.animalsworldapp.presentation.screens.auth.login.LoginDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase,
    private val saveCurrentUserUseCase: SaveCurrentUserUseCase,
    private val showedToast: ShowToastUseCase,
    private val navigatorManager: NavigatorManager
) : ViewModel() {

    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState: StateFlow<
            SignUpUiState> = _uiState.asStateFlow()

    private val _navCommandFlow = createMutableSharedFlowAsSingleLiveEvent<String>()
    val navCommandFlow: SharedFlow<String> = _navCommandFlow.asSharedFlow()

    fun onEvent(event: SignUpEvent) {
        when (event) {
            is SignUpEvent.OnEmailChanged -> doEmailChanged(event)
            is SignUpEvent.OnPasswordChanged -> doPasswordChanged(event)
            is SignUpEvent.OnNamedChanged -> doNameChanged(event)
            is SignUpEvent.OnLastNamedChanged -> doLastNameChanged(event)
            is SignUpEvent.OnSignUpClick -> onSignUpClick()
            is SignUpEvent.OnLoginClick -> onLoginClick()
            is SignUpEvent.OnNickNamedChanged -> doOnNickNamedChanged(event)
            is SignUpEvent.OnAboutYouChanged -> doAboutYouChanged(event)
            is SignUpEvent.OnLocationChanged -> doLocationChanged(event)
            else -> {}
        }
    }

    private fun onSignUpClick() {
        viewModelScope.launch {
            val result = signUpUseCase(
                name = uiState.value.name,
                lastName = uiState.value.lastName,
                email = uiState.value.email,
                password = uiState.value.password,
                location = uiState.value.location,
                nickName = uiState.value.nickName,
                aboutYou = uiState.value.aboutYou
            )

            when (result) {
                is Result.Error -> {
                    Log.e("SocialApp", result.message ?: "")
                }

                is Result.Success -> {
                    val user = result.data ?: return@launch
                    saveCurrentUserUseCase(user)
                    navigatorManager.navigateTo(MAIN_NAV_GRAPH_ROUTE, true)
                    Log.i("AnimalsApp", "${result.data}")
                }

                else -> {}
            }
        }

    }

    private fun onLoginClick() {
        _navCommandFlow.tryEmit(LoginDestination.route())
    }

    private fun doEmailChanged(event: SignUpEvent.OnEmailChanged) {
        _uiState.update { currentState ->
            currentState.copy(email = event.value)
        }

    }

    private fun doPasswordChanged(event: SignUpEvent.OnPasswordChanged) {
        _uiState.update { currentState ->
            currentState.copy(password = event.value)
        }
    }

    private fun doNameChanged(event: SignUpEvent.OnNamedChanged) {
        _uiState.update { currentState ->
            currentState.copy(name = event.value)
        }
    }

    private fun doLocationChanged(event: SignUpEvent.OnLocationChanged) {
        _uiState.update { currentState ->
            currentState.copy(location = event.value)
        }
    }

    private fun doAboutYouChanged(event: SignUpEvent.OnAboutYouChanged) {
        _uiState.update { currentState ->
            currentState.copy(aboutYou = event.value)
        }
    }

    private fun doOnNickNamedChanged(event: SignUpEvent.OnNickNamedChanged) {
        _uiState.update { currentState ->
            currentState.copy(nickName = event.value)
        }
    }

    private fun doLastNameChanged(event: SignUpEvent.OnLastNamedChanged) {
        _uiState.update { currentState ->
            currentState.copy(lastName = event.value)
        }
    }
}