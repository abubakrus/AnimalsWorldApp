package com.example.animalsworldapp.presentation.app

import androidx.lifecycle.ViewModel
import com.example.animalsworldapp.presentation.manager.NavigatorManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val navigatorManager: NavigatorManager
) : ViewModel() {

    val destinationFlow = navigatorManager.destinationFlow()

}