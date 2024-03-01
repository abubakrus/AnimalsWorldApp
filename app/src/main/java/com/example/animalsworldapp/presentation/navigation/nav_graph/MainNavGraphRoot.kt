package com.example.animalsworldapp.presentation.navigation.nav_graph

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.animalsworldapp.presentation.navigation.AppBottomNavigation
import com.example.animalsworldapp.presentation.navigation.BottomTab
import com.example.animalsworldapp.presentation.screens.all.fauna.AllFaunaDestination
import com.example.animalsworldapp.presentation.screens.all.fauna.AllFaunaScreen
import com.example.animalsworldapp.presentation.screens.all.fauna.AllFaunaViewModel
import com.example.animalsworldapp.presentation.screens.all.forest.AllForestDestination
import com.example.animalsworldapp.presentation.screens.all.forest.AllForestScreen
import com.example.animalsworldapp.presentation.screens.all.forest.AllForestViewModel
import com.example.animalsworldapp.presentation.screens.all.mountain.AllMountainDestination
import com.example.animalsworldapp.presentation.screens.all.mountain.AllMountainScreen
import com.example.animalsworldapp.presentation.screens.all.mountain.AllMountainViewModel
import com.example.animalsworldapp.presentation.screens.detail.DetailDestination
import com.example.animalsworldapp.presentation.screens.detail.DetailScreen
import com.example.animalsworldapp.presentation.screens.detail.DetailScreenViewModel
import com.example.animalsworldapp.presentation.screens.detail.ID_ARGUMENT_KEY
import com.example.animalsworldapp.presentation.screens.detail.ItemDetailType
import com.example.animalsworldapp.presentation.screens.detail.TYPE_ARGUMENT_KEY
import com.example.animalsworldapp.presentation.screens.main.MainScreen
import com.example.animalsworldapp.presentation.screens.main.MainScreenViewModel
import com.example.animalsworldapp.presentation.screens.search.SearchScreen
import com.example.animalsworldapp.presentation.screens.search.SearchViewModel
import com.example.animalsworldapp.presentation.screens.settigs.ProfileScreen
import com.example.animalsworldapp.presentation.screens.settigs.ProfileViewModel


const val MAIN_NAV_GRAPH_ROUTE = "main_nav_graph_route"

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun MainNavGraphRoot(
    darkTheme: Boolean,
    onThemeUpdated: () -> Unit,
    navigateToLocation: (String) -> Unit,
) {
    val navHostController = rememberNavController()
    Scaffold(bottomBar = {
        AppBottomNavigation(navController = navHostController)
    }
    ) { innerPaddings ->
        NavHost(
            modifier = Modifier.padding(bottom = innerPaddings.calculateBottomPadding()),
            navController = navHostController,
            startDestination = BottomTab.MAIN.route
        ) {
            composable(BottomTab.MAIN.route) {
                val viewModel: MainScreenViewModel = hiltViewModel()
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                MainScreen(
                    uiState = uiState,
                    navigateToDetails = { itemDetailType, id ->
                        navHostController.navigate("${DetailDestination.route()}/${itemDetailType.type}/$id")
                    },
                    navigateToAllFauna = {
                        navHostController.navigate(AllFaunaDestination.route())
                    },
                    navigateToAllMountain = {
                        navHostController.navigate(AllMountainDestination.route())
                    },
                    navigateToForest = {
                        navHostController.navigate(AllForestDestination.route())
                    },
                )
            }

            composable(
                route = DetailDestination.routeWithArgs(),
                arguments = DetailDestination.arguments
            ) { backStackEntry ->
                val type = backStackEntry.arguments?.getInt(TYPE_ARGUMENT_KEY) ?: -1
                val id = backStackEntry.arguments?.getString(ID_ARGUMENT_KEY)
                val viewModel: DetailScreenViewModel = hiltViewModel()
                viewModel.init(ItemDetailType.findByType(type), id)
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                DetailScreen(
                    uiState = uiState,
                    navHostController = navHostController,
                    onClickVoice = { viewModel.startPlayer(it) },
                    navigateToLocation = {
                        navigateToLocation(it)
                    }
                )
            }
            composable(BottomTab.Search.route) {
                val viewModel: SearchViewModel = hiltViewModel()
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                SearchScreen(
                    uiState = uiState,
                    onValueChange = viewModel::onValueChange,
                    navigateToDetails = { itemDetailType, id ->
                        navHostController.navigate("${DetailDestination.route()}/${itemDetailType.type}/$id")
                    }
                )
            }
            composable(BottomTab.PROFILE.route) {
                val viewModel: ProfileViewModel = hiltViewModel()
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                val navCommand by viewModel.navCommandFlow.collectAsStateWithLifecycle(initialValue = null)

                LaunchedEffect(key1 = navCommand) {
                    if (navCommand != null) navHostController.navigate(navCommand!!)
                }

                ProfileScreen(
                    onEvent = viewModel::onEvent, uiState = uiState,
                    darkTheme = darkTheme,
                    onThemeUpdated = onThemeUpdated
                )
            }

            composable(AllFaunaDestination.route()) {
                val viewModel: AllFaunaViewModel = hiltViewModel()
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()

                AllFaunaScreen(uiState = uiState, navBackStackEntry = {
                    navHostController.navigateUp()
                },
                    navigateToDetails = { itemDetailType, id ->
                        navHostController.navigate("${DetailDestination.route()}/${itemDetailType.type}/$id")
                    }
                )
            }
            composable(AllForestDestination.route()) {
                val viewModel: AllForestViewModel = hiltViewModel()
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                AllForestScreen(
                    uiState = uiState,
                    navBackStackEntry = {
                        navHostController.navigateUp()
                    },
                    navigateToDetails = { itemDetailType, id ->
                        navHostController.navigate("${DetailDestination.route()}/${itemDetailType.type}/$id")
                    }
                )
            }
            composable(AllMountainDestination.route()) {
                val viewModel: AllMountainViewModel = hiltViewModel()
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                AllMountainScreen(
                    uiState = uiState,
                    navBackStackEntry = {
                        navHostController.navigateUp()
                    },
                    navigateToDetails = { itemDetailType, id ->
                        navHostController.navigate("${DetailDestination.route()}/${itemDetailType.type}/$id")
                    }
                )
            }
        }
    }
}