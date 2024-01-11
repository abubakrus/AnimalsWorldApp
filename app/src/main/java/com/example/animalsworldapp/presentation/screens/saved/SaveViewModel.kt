package com.example.animalsworldapp.presentation.screens.saved

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animalsworldapp.domain.usecases.fauna_usecase.FetchAllFaunaUseCase
import com.example.animalsworldapp.domain.usecases.flora_usecase.FetchAllFloraUseCase
import com.example.animalsworldapp.domain.usecases.mountain_usecase.FetchAllMountainUseCase
import com.example.animalsworldapp.presentation.models.Fauna
import com.example.animalsworldapp.presentation.models.Flora
import com.example.animalsworldapp.presentation.models.Mountain
import com.example.animalsworldapp.presentation.models.toFauna
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
class SaveViewModel @Inject constructor(
    private val fetchAllFaunaUseCase: FetchAllFaunaUseCase,
    private val fetchAllFloraUseCase: FetchAllFloraUseCase,
    private val fetchAllMountainUseCase: FetchAllMountainUseCase
) : ViewModel() {

    private val _uiStateFlow = MutableStateFlow<SaveUiState>(SaveUiState.Loading)
    val uiState: StateFlow<SaveUiState> = _uiStateFlow.asStateFlow()


    private val handler = CoroutineExceptionHandler { _, throwable ->
        _uiStateFlow.tryEmit(SaveUiState.Error(throwable.localizedMessage ?: ""))
    }

    init {
        viewModelScope.launch(handler + Dispatchers.IO) {
            _uiStateFlow.tryEmit(SaveUiState.Loading)
            val contentState = SaveUiState.Loaded(
                fauna = listOf(Fauna.unknown),
                flora = listOf(Flora.unknown),
                mountain = listOf(Mountain.unknown)
            )
            _uiStateFlow.tryEmit(contentState)
        }
    }


//    private suspend fun fetchAllFauna(): List<Fauna> {
//        val fauna = fetchAllFaunaUseCase().map { it.toFauna() }
//        delay(2_000)
//        return fauna
//    }
//
//    private suspend fun fetchAllMountain(): List<Mountain> {
//        val mountain = fetchAllMountainUseCase().map { it.toMountain() }
//        delay(2_000)
//        return mountain
//    }
//
//    private suspend fun fetchAllFlora(): List<Flora> {
//        val flora = fetchAllFloraUseCase().map { it.toMountain() }
//        delay(2_000)
//        return flora
//    }
}