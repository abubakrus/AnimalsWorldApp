package com.example.animalsworldapp.presentation.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.MediaItem
import com.example.animalsworldapp.domain.usecases.fauna_usecase.FetchFaunaByIdUseCase
import com.example.animalsworldapp.domain.usecases.flora_usecase.FetchFloraByIdUseCase
import com.example.animalsworldapp.domain.usecases.forests.FetchForestByIdUseCase
import com.example.animalsworldapp.domain.usecases.mountain_usecase.FetchMountainByIdUseCase
import com.example.animalsworldapp.music_service.MusicServiceHandler
import com.example.animalsworldapp.presentation.models.toFauna
import com.example.animalsworldapp.presentation.models.toFlora
import com.example.animalsworldapp.presentation.models.toForest
import com.example.animalsworldapp.presentation.models.toMountain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.Serializable
import javax.inject.Inject


enum class ItemDetailType(
    val type: Int
) : Serializable {
    FAUNA(0),
    FLORA(1),
    MAUNTAIN(2),
    FOREST(3),
    UNKNOWN(-1);

    companion object {

        fun findByType(type: Int): ItemDetailType = entries.find { it.type == type } ?: UNKNOWN
    }
}


@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val fetchMountainByIdUseCase: FetchMountainByIdUseCase,
    private val fetchFloraByIdUseCase: FetchFloraByIdUseCase,
    private val fetchFaunaByIdUseCase: FetchFaunaByIdUseCase,
    private val fetchForestByIdUseCase: FetchForestByIdUseCase,
//    private val musicServiceHandler: MusicServiceHandler
) : ViewModel() {

    private val _uiStateFlow = MutableStateFlow<DetailScreenUiState>(DetailScreenUiState.Initial)
    val uiState: StateFlow<DetailScreenUiState> = _uiStateFlow.asStateFlow()

    private val handler = CoroutineExceptionHandler { _, throwable ->
        _uiStateFlow.tryEmit(DetailScreenUiState.Error(throwable.localizedMessage ?: ""))
    }


    fun init(type: ItemDetailType?, id: String?) {
        if (type == null || id == null) {
            // TODO: handle
            return
        }
        viewModelScope.launch(handler + Dispatchers.IO) {
            fetchById(type, id)
        }
    }

    private suspend fun fetchById(
        type: ItemDetailType,
        id: String
    ) {
        _uiStateFlow.tryEmit(DetailScreenUiState.Loading)
        val state = try {
            val content = when (type) {
                ItemDetailType.FAUNA -> {
                    val faunaDetail = fetchFaunaByIdUseCase.fetchFaunaById(id)
                    ContentType.FaunaContent(faunaDetail.data!!.toFauna())
                }

                ItemDetailType.FLORA -> {
                    val floraDetail = fetchFloraByIdUseCase.fetchFloraById(id)
                    ContentType.FloraContent(floraDetail.data!!.toFlora())
                }

                ItemDetailType.MAUNTAIN -> {
                    val mountainDetail = fetchMountainByIdUseCase.fetchMountainById(id)
                    ContentType.MountainContent(mountainDetail.data!!.toMountain())
                }

                ItemDetailType.FOREST -> {
                    val forestDetail = fetchForestByIdUseCase.invoke(id)
                    ContentType.ForestContent(forestDetail.data!!.toForest())
                }

                ItemDetailType.UNKNOWN -> ContentType.Unknown
            }
            DetailScreenUiState.Content(content)
        } catch (e: Exception) {
            DetailScreenUiState.Error("Error")
        }
        _uiStateFlow.tryEmit(state)
    }
}






