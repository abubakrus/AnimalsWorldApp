package com.example.animalsworldapp.presentation.screens.onboarding

import androidx.lifecycle.ViewModel
import com.example.animalsworldapp.domain.usecases.SetOnBoardingShowedUseCase
import com.example.animalsworldapp.presentation.manager.NavigatorManager
import com.example.animalsworldapp.presentation.navigation.nav_graph.MAIN_NAV_GRAPH_ROUTE
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val navigatorManager: NavigatorManager,
    private val setOnBoardingShowedUseCase: SetOnBoardingShowedUseCase
) : ViewModel() {
    fun onBoardingFinished() {
        setOnBoardingShowedUseCase.invoke()
        navigatorManager.navigateTo(MAIN_NAV_GRAPH_ROUTE, true)
    }
}