package com.example.animalsworldapp.presentation.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Input
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.AnimalsWorldApp.R
import com.example.animalsworldapp.presentation.components.TabBar
import com.example.animalsworldapp.presentation.screens.common.ErrorScreen
import com.example.animalsworldapp.presentation.screens.common.LoadingScreen
import com.example.animalsworldapp.presentation.screens.profile.models.HeaderInfoProfile
import com.example.animalsworldapp.presentation.screens.profile.models.ProfileItemInfo
import com.example.animalsworldapp.presentation.screens.profile.models.ProfileSwitchItem
import com.example.animalsworldapp.presentation.theme.ExtraMediumSpacing


@Composable
fun ProfileScreen(
    uiState: ProfileUiState,
    onEvent: (ProfileEvent) -> Unit,
    darkTheme: Boolean,
    onThemeUpdated: () -> Unit,
    modifier: Modifier = Modifier,

    ) {
    Scaffold(
        topBar = {
            TabBar(
                headline = stringResource(id = R.string.profile),
                alignment = Alignment.TopCenter,
            )
        }
    ) { innerPaddings ->
        when (uiState) {
            is ProfileUiState.Initial -> Unit
            is ProfileUiState.Loading -> LoadingScreen()
            is ProfileUiState.Error -> ErrorScreen(message = uiState.message, onClick = {})
            is ProfileUiState.Content -> LoadedScreenProfile(
                modifier = modifier.padding(innerPaddings),
                onEvent = onEvent,
                uiState = uiState,
                darkTheme = darkTheme,
                onThemeUpdated = onThemeUpdated
            )
        }
    }
}


@Composable
fun LoadedScreenProfile(
    uiState: ProfileUiState.Content,
    onEvent: (ProfileEvent) -> Unit,
    darkTheme: Boolean,
    onThemeUpdated: () -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            HeaderInfoProfile(user = uiState.user)
            Spacer(modifier = Modifier.height(ExtraMediumSpacing))
            ProfileSwitchItem(
                icon = Icons.Default.WbSunny,
                title = stringResource(id = R.string.change_theme),
                darkTheme = darkTheme,
                onThemeUpdated = onThemeUpdated
            )
        }
        item {
            Spacer(modifier = Modifier.height(ExtraMediumSpacing))
            ProfileItemInfo(
                icon = Icons.Default.AccountCircle,
                title = stringResource(id = R.string.edit_profile),
                onClick = { onEvent(ProfileEvent.OnEditProfile) },
                darkTheme = darkTheme
            )
        }
        item {
            Spacer(modifier = Modifier.height(ExtraMediumSpacing))
            ProfileItemInfo(
                icon = Icons.Default.AccountBox,
                title = stringResource(id = R.string.type_users),
                onClick = { onEvent(ProfileEvent.OnEditUserType) },
                darkTheme = darkTheme

            )
        }
        item {
            Spacer(modifier = Modifier.height(ExtraMediumSpacing))
            ProfileItemInfo(
                icon = Icons.Default.Language,
                title = stringResource(id = R.string.language),
                onClick = { onEvent(ProfileEvent.OnEditLanguage) },
                darkTheme = darkTheme

            )
        }
        item {
            Spacer(modifier = Modifier.height(ExtraMediumSpacing))
            ProfileItemInfo(
                icon = Icons.Default.Input,
                title = stringResource(id = R.string.sign_in),
                onClick = { onEvent(ProfileEvent.OnClickLogin) },
                darkTheme = darkTheme
            )
        }
    }
}