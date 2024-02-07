package com.example.animalsworldapp.presentation.screens.all.fauna

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
import com.example.animalsworldapp.presentation.components.TabBar
import com.example.animalsworldapp.presentation.screens.all.components.LoadingScreenForAllShow
import com.example.animalsworldapp.presentation.screens.all.components.ShowAllItem
import com.example.animalsworldapp.presentation.screens.common.ErrorScreen
import com.example.animalsworldapp.presentation.screens.detail.ItemDetailType
import com.example.animalsworldapp.presentation.theme.ExtraDoubleSpacing
import com.example.animalsworldapp.presentation.theme.ExtraMediumSpacing

@Composable
fun AllFaunaScreen(
    uiState: AllFaunaUiState,
    navBackStackEntry: () -> Unit,
    navigateToDetails: (ItemDetailType, String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            TabBar(
                headlineEnd = stringResource(id = R.string.all_fauna),
                startIcon = Icons.Default.ArrowBack,
                startIconClick = navBackStackEntry
            )
        },
    ) { innerPaddings ->
        when (uiState) {
            is AllFaunaUiState.Loading -> LoadingScreenForAllShow(
                modifier = Modifier.padding(top = ExtraDoubleSpacing + ExtraMediumSpacing)
            )

            is AllFaunaUiState.Loaded -> LoadedAllFaunaScreen(
                modifier = modifier
                    .padding(innerPaddings)
                    .fillMaxSize(),
                uiState = uiState,
                navigateToDetails = navigateToDetails
            )

            is AllFaunaUiState.Error -> ErrorScreen(
                message = uiState.error,
                onClick = {}
            )
        }
    }

}

@Composable
fun LoadedAllFaunaScreen(
    uiState: AllFaunaUiState.Loaded,
    navigateToDetails: (ItemDetailType, String) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        content = {
            items(
                items = uiState.fauna,
                key = { it.objectId }
            ) { fauna ->
                ShowAllItem(
                    backgroundImage = fauna.backgroundImage,
                    id = fauna.objectId,
                    name = fauna.name,
                    navigateToDetails = {
                        navigateToDetails(ItemDetailType.FAUNA, it)
                    },
                    location = fauna.location
                )
            }
        },
        modifier = modifier
    )
}