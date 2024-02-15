package com.example.animalsworldapp.presentation.screens.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animalsworldapp.domain.usecases.fauna_usecase.FetchLimitFaunaUseCase
import com.example.animalsworldapp.domain.usecases.flora_usecase.FetchAllFloraUseCase
import com.example.animalsworldapp.domain.usecases.forests.FetchLimitForestUseCase
import com.example.animalsworldapp.domain.usecases.mountain_usecase.FetchLimitMountainUseCase
import com.example.animalsworldapp.presentation.models.Fauna
import com.example.animalsworldapp.presentation.models.Flora
import com.example.animalsworldapp.presentation.models.Forest
import com.example.animalsworldapp.presentation.models.Mountain
import com.example.animalsworldapp.presentation.models.toFauna
import com.example.animalsworldapp.presentation.models.toFlora
import com.example.animalsworldapp.presentation.models.toForest
import com.example.animalsworldapp.presentation.models.toMountain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val fetchLimitFaunaUseCase: FetchLimitFaunaUseCase,
    private val fetchAllFloraUseCase: FetchAllFloraUseCase,
    private val fetchLimitMountainUseCase: FetchLimitMountainUseCase,
    private val fetchLimitForestUseCase: FetchLimitForestUseCase
) : ViewModel() {

    private val _uiStateFlow = MutableStateFlow<MainScreenUiState>(MainScreenUiState.Loading)
    val uiState: StateFlow<MainScreenUiState> = _uiStateFlow.asStateFlow()

    private val handler = CoroutineExceptionHandler { _, throwable ->
        _uiStateFlow.tryEmit(MainScreenUiState.Error(throwable.localizedMessage ?: ""))
    }

    init {
        viewModelScope.launch(handler + Dispatchers.IO) {
            _uiStateFlow.tryEmit(MainScreenUiState.Loading)

            val contentState = MainScreenUiState.Loaded.Companion.Builder()
            val deferredList = coroutineScope {
                listOf(
                    async { fetchLimitFauna(contentState) },
                    async { fetchAllFlora(contentState) },
                    async { fetchLimitMountain(contentState) },
                    async { fetchLimitForest(contentState) },
                )
            }
            deferredList.awaitAll()
            _uiStateFlow.tryEmit(contentState.build())
        }
    }

    private suspend fun fetchLimitFauna(state: MainScreenUiState.Loaded.Companion.Builder) {
        val faunaLimited = fetchLimitFaunaUseCase.invoke(10)
        val faunaList = faunaLimited.data?.map { it.toFauna() } ?: emptyList()
        state.fauna(fauna = faunaList)
    }

    private suspend fun fetchLimitMountain(
        state: MainScreenUiState.Loaded.Companion.Builder
    ) {
        val mountainLimited = fetchLimitMountainUseCase.invoke(7)
        val mountain = mountainLimited.data?.map { it.toMountain() } ?: emptyList()
        state.mountain(mountain)
    }

    private suspend fun fetchLimitForest(
        state: MainScreenUiState.Loaded.Companion.Builder
    ) {
        val forestLimited = fetchLimitForestUseCase.invoke(7)
        val forest = forestLimited.data?.map { it.toForest() } ?: emptyList()
        state.forest(forest)
    }

    private suspend fun fetchAllFlora(
        state: MainScreenUiState.Loaded.Companion.Builder
    ) {
        val flora =  fetchAllFloraUseCase().map { it.toFlora() }
        state.flora(flora)
    }
}