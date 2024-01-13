package com.example.animalsworldapp.presentation.screens.detail_fauna

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.animalsworldapp.presentation.models.Fauna
import com.example.animalsworldapp.presentation.screens.common.ErrorScreen
import com.example.animalsworldapp.presentation.screens.detail_fauna.models.FaunaDetailItem


@Composable
fun DetailFaunaScreen(
    uiState: DetailFaunaUiState, modifier: Modifier = Modifier
) {
    Scaffold(

    ) { innerPaddings ->
        when (uiState) {
            is DetailFaunaUiState.Initial -> {}
            is DetailFaunaUiState.Loading -> {}
            is DetailFaunaUiState.Content -> {}
            is DetailFaunaUiState.Error -> ErrorScreen(message = uiState.message, onClick = {})
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContentDetailFaunaScreen(
    uiState: DetailFaunaUiState.Content,
    modifier: Modifier = Modifier,
    fauna: Fauna,
    navigateBackStack: () -> Unit,
    onClickVoice: () -> Unit,
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
            if (fauna == Fauna.unknown) {
                Box(
                    modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Unknown", style = MaterialTheme.typography.titleMedium
                    )
                }
            } else {
                FaunaDetailItem(
                    navigateBackStack = navigateBackStack,
                    fauna = uiState.fauna,
                    onClickVoice = onClickVoice
                )
            }
        }
    }
}
