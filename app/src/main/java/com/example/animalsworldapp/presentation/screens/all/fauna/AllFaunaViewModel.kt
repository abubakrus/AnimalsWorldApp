package com.example.animalsworldapp.presentation.screens.all.fauna

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animalsworldapp.domain.usecases.fauna_usecase.FetchAllFaunaUseCase
import com.example.animalsworldapp.presentation.models.Fauna
import com.example.animalsworldapp.presentation.models.toFauna
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
class AllFaunaViewModel @Inject constructor(
    private val fetchAllFaunaUseCase: FetchAllFaunaUseCase,
) : ViewModel() {

    private val _uiStateFlow = MutableStateFlow<AllFaunaUiState>(AllFaunaUiState.Loading)
    val uiState: StateFlow<AllFaunaUiState> = _uiStateFlow.asStateFlow()

    private val handler = CoroutineExceptionHandler { _, throwable ->
        _uiStateFlow.tryEmit(AllFaunaUiState.Error(throwable.localizedMessage ?: ""))
    }

    init {
        viewModelScope.launch(handler + Dispatchers.IO) {
            _uiStateFlow.tryEmit(AllFaunaUiState.Loading)
            val contentState = AllFaunaUiState.Loaded(fauna = fetchAllFauna())
            _uiStateFlow.tryEmit(contentState)
        }
    }

    private suspend fun fetchAllFauna(): List<Fauna> {
        val fauna = fetchAllFaunaUseCase().map { it.toFauna() }
        delay(2_000)
        return fauna
    }
}