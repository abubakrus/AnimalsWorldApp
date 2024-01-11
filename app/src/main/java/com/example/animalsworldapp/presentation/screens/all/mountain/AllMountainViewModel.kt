package com.example.animalsworldapp.presentation.screens.all.mountain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animalsworldapp.domain.usecases.mountain_usecase.FetchAllMountainUseCase
import com.example.animalsworldapp.presentation.models.Mountain
import com.example.animalsworldapp.presentation.models.toMountain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AllMountainViewModel @Inject constructor(
    private val fetchAllMountainUseCase: FetchAllMountainUseCase
) : ViewModel() {
    private val _uiStateFlow = MutableStateFlow<AllMountainUiState>(AllMountainUiState.Loading)
    val uiState: StateFlow<AllMountainUiState> = _uiStateFlow.asStateFlow()

    private val handler = CoroutineExceptionHandler { _, throwable ->
        _uiStateFlow.tryEmit(AllMountainUiState.Error(throwable.localizedMessage ?: ""))
    }

    init {
        viewModelScope.launch(handler + Dispatchers.IO) {
            _uiStateFlow.tryEmit(AllMountainUiState.Loading)
            val contentState = AllMountainUiState.Loaded(
                mountain = fetchAllMountain()
            )

                .copy(mountain = fetchAllMountain())
            _uiStateFlow.tryEmit(contentState)
        }
    }

    private suspend fun fetchAllMountain(): List<Mountain> {
        val mountain = fetchAllMountainUseCase().map { it.toMountain() }
        delay(2_000)
        return mountain
    }

}