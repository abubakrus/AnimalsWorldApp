package com.example.animalsworldapp.presentation.screens.search

import androidx.lifecycle.ViewModel
import com.example.animalsworldapp.domain.usecases.fauna_usecase.FetchFaunaByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchByIdUseCase: FetchFaunaByIdUseCase
) : ViewModel() {

    private val searQueryFlow = MutableStateFlow("")


    private val _uiStateFlow = MutableStateFlow<SearchUiState>(SearchUiState())
    val uiState: StateFlow<SearchUiState> = _uiStateFlow.asStateFlow()

    private val searchQueryFlow = MutableStateFlow("")

//    init {
//        searQueryFlow
//            .onEach { query ->
//                _uiStateFlow.tryEmit(_uiStateFlow.value.copy(query = query, isLoading = true))
//            }
//            .debounce(300)
//            .onEach(::startSearch)
//            .launchIn(viewModelScope)
//    }

//    private fun startSearch(query: String) {
//        viewModelScope.launch {
//            val content = searchMoviesByQueryUseCase.searchByQuery(query)
//            _uiStateFlow.tryEmit(
//                _uiStateFlow.value.copy(
//                    query = content,
//                    isLoading = false
//                )
//            )
//        }
//    }

    fun onValueChange(value: String) {
        searQueryFlow.tryEmit(value)
    }


}