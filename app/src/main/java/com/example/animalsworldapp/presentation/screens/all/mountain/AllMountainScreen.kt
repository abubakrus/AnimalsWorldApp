package com.example.animalsworldapp.presentation.screens.all.mountain

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
import com.example.AnimalsWorldApp.R
import com.example.animalsworldapp.presentation.components.MountainItem
import com.example.animalsworldapp.presentation.components.TabBar
import com.example.animalsworldapp.presentation.screens.common.ErrorScreen
import com.example.animalsworldapp.presentation.screens.common.LoadingScreen
import com.example.animalsworldapp.presentation.screens.detail.ItemDetailType

@Composable
fun AllMountainScreen(
    uiState: AllMountainUiState,
    navBackStackEntry: () -> Unit,
    navigateToDetails: (ItemDetailType, String) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TabBar(
                title = stringResource(id = R.string.all_mountain),
                startIcon = Icons.Default.ArrowBack,
                startIconClick = navBackStackEntry
            )
        }
    ) { innerPaddings ->
        when (uiState) {
            is AllMountainUiState.Loading -> LoadingScreen()
            is AllMountainUiState.Loaded -> LoadedAllMountainScreen(
                uiState = uiState,
                modifier = modifier
                    .padding(innerPaddings)
                    .fillMaxSize(),
                navigateToDetails = navigateToDetails
            )

            is AllMountainUiState.Error -> ErrorScreen(
                message = uiState.error,
                onClick = { })
        }
    }
}

@Composable
fun LoadedAllMountainScreen(
    uiState: AllMountainUiState.Loaded,
    navigateToDetails: (ItemDetailType, String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(200.dp),
        verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        content = {
            items(
                items = uiState.mountain,
                key = { it.id }
            ) { mountain ->
                MountainItem(
                    mountain = mountain,
                    navigateToDetails = {
                        navigateToDetails(ItemDetailType.MAUNTAIN, it)
                    }
                )
            }

        },
        modifier = modifier
    )
}


