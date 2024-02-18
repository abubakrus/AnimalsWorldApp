package com.example.animalsworldapp.presentation.screens.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animalsworldapp.domain.models.FaunaDomain
import com.example.animalsworldapp.domain.usecases.fauna_usecase.FetchAllFaunaUseCase
import com.example.animalsworldapp.domain.usecases.fauna_usecase.SearchByQueryFaunaUseCase
import com.example.animalsworldapp.presentation.models.toFauna
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val fetchAllFaunaUseCase: FetchAllFaunaUseCase,
    private val searchByQueryFaunaUseCase: SearchByQueryFaunaUseCase
) : ViewModel() {

    private val searQueryFlow = MutableStateFlow("")


    private val _uiStateFlow = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState> = _uiStateFlow.asStateFlow()

    init {
        searQueryFlow.onEach { query ->
            _uiStateFlow.tryEmit(
                _uiStateFlow.value.copy(
                    query = query, isLoading = true
                )
            )
        }
            .debounce(300).onEach(
                ::startSearch
            ).launchIn(viewModelScope)
    }

    private fun startSearch(query: String) {
        viewModelScope.launch {
            val content = fetchAllFaunaUseCase.invoke()
            val result = content.filter { it.name.contains(query, ignoreCase = true) }
            val fauna = result.map { it.toFauna() }
            _uiStateFlow.tryEmit(
                _uiStateFlow.value.copy(
                    fauna = fauna,
                    isLoading = false
                )
            )
        }
    }

    fun onValueChange(value: String) {
        searQueryFlow.tryEmit(value)
    }
}