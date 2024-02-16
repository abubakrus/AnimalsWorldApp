package com.example.animalsworldapp.presentation.screens.detail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.animalsworldapp.presentation.screens.common.ErrorScreen
import com.example.animalsworldapp.presentation.screens.detail.models.FaunaDetailItem
import com.example.animalsworldapp.presentation.screens.detail.models.FloraDetailItem
import com.example.animalsworldapp.presentation.screens.detail.models.ForestDetailItem
import com.example.animalsworldapp.presentation.screens.detail.models.LoadingScreenDetail
import com.example.animalsworldapp.presentation.screens.detail.models.MountainDetailItem

@Composable
fun DetailScreen(
    uiState: DetailScreenUiState,
    navHostController: NavHostController,
    onClickVoice: (String?) -> Unit,
    navigateToLocation: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold { innerPaddings ->
        when (uiState) {
            is DetailScreenUiState.Initial -> Unit
            is DetailScreenUiState.Loading -> LoadingScreenDetail()
            is DetailScreenUiState.Error -> ErrorScreen(message = uiState.message, onClick = {})
            is DetailScreenUiState.Content -> {
                LoadedDetailScreen(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(innerPaddings),
                    navigateBackStack = { navHostController.navigateUp() },
                    contentType = uiState.contentType,
                    onClickVoice = {
                        onClickVoice(uiState.contentType.voice)
                    },
                    navigateToLocation = {
                        navigateToLocation(it)
                    }
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
    onClickVoice: () -> Unit,
    navigateToLocation: (String) -> Unit,

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
            when (contentType) {
                is ContentType.Unknown -> Unknown()
                is ContentType.MountainContent -> MountainDetailItem(
                    navigateBackStack = navigateBackStack,
                    name = contentType.name,
                    backgroundImage = contentType.backgroundImage,
                    interestingFact = contentType.interestingFact,
                    image = contentType.image,
                    about = contentType.about,
                    location = contentType.location,
                    locationImage = contentType.locationImage,
                    navigateToLocation = { navigateToLocation(it) }

                )

                is ContentType.FloraContent -> FloraDetailItem(
                    navigateBackStack = navigateBackStack,
                    name = contentType.name,
                    backgroundImage = contentType.backgroundImage,
                    interestingFact = contentType.interestingFact,
                    image = contentType.image,
                    about = contentType.about,
                    location = contentType.location,
                    navigateToLocation = { navigateToLocation(it) }
                )

                is ContentType.ForestContent -> ForestDetailItem(
                    navigateBackStack = navigateBackStack,
                    about = contentType.about,
                    location = contentType.location,
                    name = contentType.name,
                    backgroundImage = contentType.backgroundImage,
                    interestingFact = contentType.interestingFact,
                    image = contentType.image,
                    navigateToLocation = { navigateToLocation(it) }
                )

                is ContentType.FaunaContent -> FaunaDetailItem(
                    navigateBackStack = navigateBackStack,
                    about = contentType.about,
                    location = contentType.location,
                    name = contentType.name,
                    backgroundImage = contentType.backgroundImage,
                    interestingFact = contentType.interestingFact,
                    image = contentType.image,
                    onClickVoice = { onClickVoice() },
                    locationImage = contentType.locationImage,
                    animalsClasses = contentType.animalsClasses,
                    navigateToLocation = { navigateToLocation(it) },
                    videoUri = "ktZ-zfv8Lm8"
                )

            }
        }
    }
}


@Composable
fun Unknown() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Unknown",
            style = MaterialTheme.typography.titleMedium
        )
    }
}

