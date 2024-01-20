package com.example.animalsworldapp.presentation.screens.all.forest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animalsworldapp.domain.usecases.forests.FetchAllForestsUseCase
import com.example.animalsworldapp.presentation.models.Forest
import com.example.animalsworldapp.presentation.models.toForest
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
class AllForestViewModel @Inject constructor(
    private val fetchAllForestsUseCase: FetchAllForestsUseCase
) : ViewModel() {

    private val _uiStateFlow = MutableStateFlow<AllForestUiState>(AllForestUiState.Loading)
    val uiState: StateFlow<AllForestUiState> = _uiStateFlow.asStateFlow()

    private val handler = CoroutineExceptionHandler { _, throwable ->
        _uiStateFlow.tryEmit(AllForestUiState.Error(throwable.localizedMessage ?: ""))
    }

    init {
        viewModelScope.launch(handler + Dispatchers.IO) {
            _uiStateFlow.tryEmit(AllForestUiState.Loading)
            val contentState = AllForestUiState.Loaded(
                forest = fetchAllForests()
            )

                .copy(forest = fetchAllForests())
            _uiStateFlow.tryEmit(contentState)
        }
    }

    private suspend fun fetchAllForests(): List<Forest> {
        val forest = fetchAllForestsUseCase().map { it.toForest() }
        delay(2_000)
        return forest
    }

}