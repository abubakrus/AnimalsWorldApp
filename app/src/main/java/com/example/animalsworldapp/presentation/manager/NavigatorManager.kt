package com.example.animalsworldapp.presentation.manager

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterNotNull
import javax.inject.Inject

interface NavigatorManager {
    fun destinationFlow(): Flow<Pair<String, Boolean>>

    fun navigateTo(destination: String, isClearBackStack: Boolean = false)
}


class NavigatorManagerImpl @Inject constructor(

) : NavigatorManager {

    private val destinationFlow = MutableStateFlow("" to false)
    override fun destinationFlow(): Flow<Pair<String, Boolean>> {
        return destinationFlow.asStateFlow().filterNotNull()
    }

    override fun navigateTo(destination: String, isClearBackStack: Boolean) {
        destinationFlow.tryEmit(Pair(destination, isClearBackStack))
    }
}