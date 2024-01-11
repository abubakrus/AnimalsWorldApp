package com.example.animalsworldapp.presentation.screens.detail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardVoice
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.animalsworldapp.presentation.components.DetailBackgroundItem
import com.example.animalsworldapp.presentation.screens.common.ErrorScreen
import com.example.animalsworldapp.presentation.screens.common.LoadingScreen

@Composable
fun DetailScreen(
    uiState: DetailScreenUiState,
    navHostController: NavHostController,
    onClickVoice: () -> Unit = {},
    voice: String? = String(),
    modifier: Modifier = Modifier,
    ) {
    Scaffold { innerPaddings ->
        when (uiState) {
            is DetailScreenUiState.Initial -> Unit
            is DetailScreenUiState.Loading -> LoadingScreen()
            is DetailScreenUiState.Error -> ErrorScreen(message = uiState.message, onClick = {})
            is DetailScreenUiState.Content -> {
                LoadedDetailScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPaddings),
                    navigateBackStack = { navHostController.navigateUp() },
                    contentType = uiState.contentType,
                )
            }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LoadedDetailScreen(
    modifier: Modifier = Modifier,
    contentType: ContentType,
    navigateBackStack: () -> Unit,
    onClickVoice: () -> Unit = {},
    voice: String? = String()
) {
    BoxWithConstraints(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        val screenHeight = maxHeight
        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = scrollState)
        ) {
            if (contentType == ContentType.Unknown) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Unknown",
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            } else {
                DetailBackgroundItem(
                    navigateBackStack = navigateBackStack,
                    about = contentType.about,
                    location = contentType.location,
                    name = contentType.name,
                    backgroundImage = contentType.backgroundImage
                )
                if (voice != null) Card(
                    modifier = Modifier
                        .size(45.dp)
                        .clickable { onClickVoice() }
                        .clip(CircleShape),
                    shape = CardDefaults.shape,
                ) {
                    Icon(
                        modifier = Modifier,
                        imageVector = Icons.Default.KeyboardVoice,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.background
                    )
                }
            }
        }
    }
}
