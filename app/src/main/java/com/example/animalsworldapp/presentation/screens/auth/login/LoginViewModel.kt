package com.example.animalsworldapp.presentation.screens.auth.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animalsworldapp.domain.common.Result
import com.example.animalsworldapp.domain.models.UsersDomain
import com.example.animalsworldapp.presentation.extensions.createMutableSharedFlowAsSingleLiveEvent
import com.example.animalsworldapp.presentation.manager.NavigatorManager
import com.example.animalsworldapp.presentation.manager.toast.ShowToastUseCase
import com.example.animalsworldapp.presentation.navigation.nav_graph.MAIN_NAV_GRAPH_ROUTE
import com.example.animalsworldapp.presentation.screens.auth.signup.SignUpDestination
import com.example.animalsworldapp.domain.usecases.current_user.SaveCurrentUserUseCase
import com.example.animalsworldapp.domain.usecases.signin.SingInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

val default_error_message = "Something"

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val singInUseCase: SingInUseCase,
    private val saveCurrentUserUseCase: SaveCurrentUserUseCase,
    private val showedToast: ShowToastUseCase,
    private val navigatorManager: NavigatorManager
) : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    private val _navCommandFlow = createMutableSharedFlowAsSingleLiveEvent<String>()
    val navCommandFlow: SharedFlow<String> = _navCommandFlow.asSharedFlow()


    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.OnEmailChanged -> doEmailChanged(event)
            is LoginEvent.OnPasswordChanged -> doPasswordChanged(event)
            is LoginEvent.OnSignUpClick -> onSignUpClick()
            is LoginEvent.OnLoginClick -> onLoginClick()
        }
    }

    private fun onSignUpClick() {
        _navCommandFlow.tryEmit(SignUpDestination.route())
    }

    private fun onLoginClick() {
        _uiState.update { currentState ->
            currentState.copy(isAuthentication = true)
        }
        val email = _uiState.value.email
        val password = _uiState.value.password

        viewModelScope.launch {
            val result = singInUseCase(
                email = email, password = password
            )
        }
    }

    private fun handleLoginResult(
        result: Result<UsersDomain>
    ) {
        when (result) {
            is Result.Error -> {
                showedToast.showToast(result.message ?: default_error_message)
                Log.e("SocialApp", "message = ${result.message}")
            }

            is Result.Success -> {
                val user = result.data
                if (user == null) {
                    showedToast.showToast(result.message ?: default_error_message)
                    return
                }
                saveCurrentUserUseCase(user)
                navigatorManager.navigateTo(MAIN_NAV_GRAPH_ROUTE, true)
                Log.i("SocialApp", "data = ${result.data}")
            }

        }
        _uiState.update { currentState ->
            currentState.copy(isAuthentication = false)
        }
    }

    private fun doEmailChanged(event: LoginEvent.OnEmailChanged) {
        _uiState.update { currentState ->
            currentState.copy(email = event.value)
        }

    }

    private fun doPasswordChanged(event: LoginEvent.OnPasswordChanged) {
        _uiState.update { currentState ->
            currentState.copy(password = event.value)
        }
    }


}