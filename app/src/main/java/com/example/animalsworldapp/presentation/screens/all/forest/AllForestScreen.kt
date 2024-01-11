package com.example.animalsworldapp.presentation.screens.all.forest

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.AnimalsWorldApp.R
import com.example.animalsworldapp.presentation.components.AllForestItem
import com.example.animalsworldapp.presentation.components.TabBar
import com.example.animalsworldapp.presentation.screens.common.ErrorScreen
import com.example.animalsworldapp.presentation.screens.common.LoadingScreen

@Composable
fun AllForestScreen(
    uiState: AllForestUiState, navHostController: NavHostController, modifier: Modifier = Modifier
) {
    Scaffold(topBar = {
        TabBar(title = stringResource(id = R.string.all_forest),
            startIcon = Icons.Default.ArrowBack,
            startIconClick = {
                navHostController.navigateUp()
            })
    }) { innerPaddings ->
        when (uiState) {
            is AllForestUiState.Loading -> LoadingScreen()
            is AllForestUiState.Loaded -> LoadedAllMountainScreen(
                uiState = uiState, modifier = modifier
                    .padding(innerPaddings)
                    .fillMaxSize()
            )

            is AllForestUiState.Error -> ErrorScreen(message = uiState.error, onClick = { })
        }
    }
}

@Composable
fun LoadedAllMountainScreen(
    uiState: AllForestUiState.Loaded, modifier: Modifier = Modifier
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(200.dp),
        verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        content = {
            items(items = uiState.forest, key = { it.id }) { forest ->
                AllForestItem(forest = forest)
            }

        },
        modifier = modifier
    )
}


