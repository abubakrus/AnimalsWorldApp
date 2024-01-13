package com.example.animalsworldapp.presentation.screens.detail_fauna

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class DetailFaunaViewModel @Inject constructor(
) : ViewModel() {

    private val _uiStateFlow = MutableStateFlow<DetailFaunaUiState>(DetailFaunaUiState.Initial)
    val uiState: StateFlow<DetailFaunaUiState> = _uiStateFlow.asStateFlow()

    private val handler = CoroutineExceptionHandler { _, throwable ->
        _uiStateFlow.tryEmit(DetailFaunaUiState.Error(throwable.localizedMessage ?: ""))
    }
}

