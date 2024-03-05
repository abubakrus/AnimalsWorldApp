package com.example.animalsworldapp.presentation.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animalsworldapp.domain.usecases.ShouldOnBoardingPassedUseCase
import com.example.animalsworldapp.presentation.manager.NavigatorManager
import com.example.animalsworldapp.presentation.navigation.nav_graph.MAIN_NAV_GRAPH_ROUTE
import com.example.animalsworldapp.presentation.screens.onboarding.OnBoardingDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val SPLASH_DELAY_TIME = 3_000L

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val shouldOnBoardingPassedUseCase: ShouldOnBoardingPassedUseCase,
    private val navigatorManager: NavigatorManager
) : ViewModel() {
    init {
        val isOnBoardingPassed = shouldOnBoardingPassedUseCase()
        viewModelScope.launch {
            delay(SPLASH_DELAY_TIME)
            val destination = when {
                isOnBoardingPassed -> MAIN_NAV_GRAPH_ROUTE
                else -> OnBoardingDestination.route()
            }
            navigatorManager.navigateTo(destination, true)
        }
    }
}