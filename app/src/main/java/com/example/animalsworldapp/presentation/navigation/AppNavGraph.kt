package com.example.animalsworldapp.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.animalsworldapp.presentation.navigation.nav_graph.MAIN_NAV_GRAPH_ROUTE
import com.example.animalsworldapp.presentation.navigation.nav_graph.MainNavGraphRoot
import com.example.animalsworldapp.presentation.screens.onboarding.OnBoardingDestination
import com.example.animalsworldapp.presentation.screens.onboarding.OnBoardingScreen
import com.example.animalsworldapp.presentation.screens.onboarding.OnBoardingViewModel
import com.example.animalsworldapp.presentation.screens.splash.SplashDestination
import com.example.animalsworldapp.presentation.screens.splash.SplashScreen
import com.example.animalsworldapp.presentation.screens.splash.SplashViewModel


@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun AppNavGraph(
    darkTheme: Boolean,
    onThemeUpdated: () -> Unit,
    navigateToLocation: (String) -> Unit,
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = SplashDestination.route()
    ) {
        composable(SplashDestination.route()) {
            val viewModel: SplashViewModel = hiltViewModel()
            SplashScreen()
        }
        composable(OnBoardingDestination.route()) {
            val viewModel: OnBoardingViewModel = hiltViewModel()
            OnBoardingScreen(navigateToMainScreen = { viewModel.onBoardingFinished() })
        }
        composable(MAIN_NAV_GRAPH_ROUTE) {
            MainNavGraphRoot(
                darkTheme = darkTheme,
                onThemeUpdated = onThemeUpdated,
                navigateToLocation = {
                    navigateToLocation(it)
                }

            )
        }
    }
}
