package com.example.animalsworldapp.presentation.screens.main

import HorizontalPagerDialog
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.AnimalsWorldApp.R
import com.example.animalsworldapp.presentation.components.HeadingText
import com.example.animalsworldapp.presentation.components.TabBar
import com.example.animalsworldapp.presentation.screens.common.ErrorScreen
import com.example.animalsworldapp.presentation.screens.detail.ItemDetailType
import com.example.animalsworldapp.presentation.screens.main.models.HorizontalPagerForForest
import com.example.animalsworldapp.presentation.screens.main.models.HorizontalPagerForMountain
import com.example.animalsworldapp.presentation.screens.main.models.LoadingScreenMain
import com.example.animalsworldapp.presentation.screens.main.models.MainScreenHorizontalFlora
import com.example.animalsworldapp.presentation.theme.ExtraLargeSpacing


@Composable
fun MainScreen(
    uiState: MainScreenUiState,
    navigateToDetails: (ItemDetailType, String) -> Unit,
    navigateToAllFauna: () -> Unit,
    navigateToAllMountain: () -> Unit,
    navigateToForest: () -> Unit,
    modifier: Modifier = Modifier,
    ) {
    Scaffold(
        topBar = {
        TabBar(
            headline = stringResource(id = R.string.hello),
            alignment = Alignment.TopCenter,
        )
    }
    ) { innerPaddings ->
        when (uiState) {
            is MainScreenUiState.Loading -> LoadingScreenMain(
                modifier = modifier.padding(
                    innerPaddings
                )
            )
            is MainScreenUiState.Loaded -> LoadedMainScreen(
                uiState = uiState,
                modifier = modifier
                    .padding(innerPaddings)
                    .fillMaxSize(),
                navigateToDetails = navigateToDetails,
                navigateToAllFauna = navigateToAllFauna,
                navigateToAllMountain = navigateToAllMountain,
                navigateToForest = navigateToForest

            )
            is MainScreenUiState.Error -> ErrorScreen(message = uiState.message, onClick = {})
        }
    }
}

@Composable
fun LoadedMainScreen(
    uiState: MainScreenUiState.Loaded,
    modifier: Modifier = Modifier,
    navigateToDetails: (ItemDetailType, String) -> Unit,
    navigateToAllFauna: () -> Unit,
    navigateToAllMountain: () -> Unit,
    navigateToForest: () -> Unit,

    ) {
    LazyColumn(
        modifier = modifier
    ) {
        item {
            Spacer(modifier = Modifier.height(ExtraLargeSpacing))
            MainScreenHorizontalFlora(
                navigateToDetails = { navigateToDetails(ItemDetailType.FLORA, it) },
                floraList = uiState.flora,
            )
        }
        item {
            HeadingText(text = stringResource(id = R.string.fauna),
                navigateToAllShow = { navigateToAllFauna() })
            HorizontalPagerDialog(
                faunaList = uiState.fauna,
                navigateToDetails = {
                    navigateToDetails(ItemDetailType.FAUNA, it)
                },
            )
        }
        item {
            HeadingText(text = stringResource(id = R.string.mountain),
                navigateToAllShow = { navigateToAllMountain() })
            HorizontalPagerForMountain(
                mountainList = uiState.mountain,
                navigateToDetails = {
                    navigateToDetails(ItemDetailType.MAUNTAIN, it)
                },
            )
        }
        item {
            HeadingText(text = stringResource(id = R.string.forest),
                navigateToAllShow = { navigateToForest() })
            HorizontalPagerForForest(
                forestList = uiState.forest,
                navigateToDetails = {
                    navigateToDetails(ItemDetailType.FOREST, it)
                },
            )
        }
    }
}
