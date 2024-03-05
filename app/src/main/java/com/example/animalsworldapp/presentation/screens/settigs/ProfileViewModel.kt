package com.example.animalsworldapp.presentation.screens.settigs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animalsworldapp.presentation.extensions.createMutableSharedFlowAsSingleLiveEvent
import com.example.animalsworldapp.presentation.manager.toast.ShowToastUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val showToast: ShowToastUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow<ProfileUiState>(ProfileUiState.Initial)
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    private val _navCommandFlow = createMutableSharedFlowAsSingleLiveEvent<String>()
    val navCommandFlow: SharedFlow<String> = _navCommandFlow.asSharedFlow()

    fun onEvent(event: ProfileEvent) {
        when (event) {
            is ProfileEvent.OnEditUserType -> onEditUserType()
            is ProfileEvent.OnEditLanguage -> onEditLanguage()
            is ProfileEvent.OnEditChangeTheme -> {}
        }
    }

    init {
        try {
            viewModelScope.launch {
                _uiState.tryEmit(ProfileUiState.Content)
            }
        } catch (e: Throwable) {
            val errorState = ProfileUiState.Error(e.stackTraceToString())
            _uiState.tryEmit(errorState)
        }
    }

    private fun onEditLanguage() {
        showToast.showToast(message = "Эта функция сейчас в разработке")
        return
    }

    private fun onEditUserType() {
        showToast.showToast(message = "Эта функция сейчас в разработке")
        return
    }
}