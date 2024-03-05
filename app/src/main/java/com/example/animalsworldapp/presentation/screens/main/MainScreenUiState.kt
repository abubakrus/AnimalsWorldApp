package com.example.animalsworldapp.presentation.screens.main

import com.example.animalsworldapp.presentation.models.Fauna
import com.example.animalsworldapp.presentation.models.Flora
import com.example.animalsworldapp.presentation.models.Forest
import com.example.animalsworldapp.presentation.models.Mountain

sealed class MainScreenUiState {
    data object Loading : MainScreenUiState()

    data class Loaded(
        val fauna: List<Fauna> = emptyList(),
        val flora: List<Flora> = emptyList(),
        val mountain: List<Mountain> = emptyList(),
        val forest: List<Forest> = emptyList()
    ) : MainScreenUiState() {
        companion object {
            class Builder private constructor(
                private var fauna: List<Fauna> = emptyList(),
                private var flora: List<Flora> = emptyList(),
                private var mountain: List<Mountain> = emptyList(),
                private var forest: List<Forest> = emptyList()
            ) {
                constructor() : this(emptyList())
                constructor(loaded: Loaded) : this(
                    fauna = loaded.fauna,
                    flora = loaded.flora,
                    mountain = loaded.mountain,
                    forest = loaded.forest
                )
                fun fauna(fauna: List<Fauna>) = apply { this.fauna = fauna }
                fun flora(flora: List<Flora>) = apply { this.flora = flora }
                fun mountain(mountain: List<Mountain>) = apply { this.mountain = mountain }
                fun forest(forest: List<Forest>) = apply { this.forest = forest }
                fun build() = Loaded(
                    fauna = this.fauna,
                    forest = this.forest,
                    mountain = this.mountain,
                    flora = this.flora,
                )
            }
        }
    }
    data class Error(
        val message: String
    ) : MainScreenUiState()
}