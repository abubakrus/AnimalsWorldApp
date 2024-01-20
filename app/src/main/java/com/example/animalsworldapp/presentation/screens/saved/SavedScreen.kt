package com.example.animalsworldapp.presentation.screens.saved

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.animalsworldapp.presentation.components.HeadingText
import com.example.animalsworldapp.presentation.extensions.SpacerHeight
import com.example.animalsworldapp.presentation.screens.common.ErrorScreen
import com.example.animalsworldapp.presentation.screens.common.LoadingScreen
import com.example.animalsworldapp.presentation.screens.saved.models.HorizontalPagerWithIndicators
import com.example.animalsworldapp.presentation.screens.saved.models.VerticalItem
import com.example.animalsworldapp.presentation.theme.ExtraMediumSpacing
import com.example.animalsworldapp.presentation.theme.ExtraSpacing


@Composable
fun SaveScreen(
    uiState: SaveUiState,
    modifier: Modifier = Modifier,
) {
    when (uiState) {
        is SaveUiState.Loading -> LoadingScreen()
        is SaveUiState.Error -> ErrorScreen(message = uiState.message, onClick = {})
        is SaveUiState.Loaded -> LoadedSaveScreen(
            uiState = uiState,
            modifier = modifier
        )
    }
}


@Composable
fun LoadedSaveScreen(
    uiState: SaveUiState.Loaded,
    modifier: Modifier = Modifier,
) {
    var screenHeight: Dp
    BoxWithConstraints(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding()
    ) {
        screenHeight = maxHeight
        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {
            HeadingText(
                text = "Favorite",
                isShowAll = false,
                navigateToAllShow = {}
            )
            SpacerHeight(ExtraMediumSpacing)
            HorizontalPagerWithIndicators(
                modifier = Modifier,
                mountain = uiState.mountain
            )
            SpacerHeight(ExtraSpacing)
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Adaptive(200.dp),
                verticalItemSpacing = 4.dp,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                content = {
                    items(items = uiState.fauna, key = { it.objectId }) { fauna ->
                        VerticalItem(fauna = fauna)
                    }
                },
                modifier = Modifier
            )
        }
    }
}


