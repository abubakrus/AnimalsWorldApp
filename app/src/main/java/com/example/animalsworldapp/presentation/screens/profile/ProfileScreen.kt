package com.example.animalsworldapp.presentation.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.AnimalsWorldApp.R
import com.example.animalsworldapp.presentation.extensions.SpacerHeight
import com.example.animalsworldapp.presentation.screens.profile.models.HeaderInfoProfile
import com.example.animalsworldapp.presentation.screens.profile.models.ProfileItemInfo
import com.example.animalsworldapp.presentation.screens.profile.models.ProfileSwitchItem
import com.example.animalsworldapp.presentation.theme.ExtraLargeSpacing
import com.example.animalsworldapp.presentation.theme.ExtraMediumSpacing


@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    onEvent: (ProfileEvent) -> Unit,
) {
    Scaffold { innerPaddings ->
        Column {
            LoadedScreenProfile(modifier = modifier.padding(innerPaddings), onEvent = onEvent)
        }
    }

}


@Composable
fun LoadedScreenProfile(
    modifier: Modifier = Modifier,
    onEvent: (ProfileEvent) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderInfoProfile()
        SpacerHeight(ExtraLargeSpacing)
        ProfileSwitchItem(
            icon = Icons.Default.WbSunny,
            title = stringResource(id = R.string.change_theme),
        )
        SpacerHeight(ExtraMediumSpacing)
        ProfileItemInfo(
            icon = Icons.Default.AccountCircle,
            title = stringResource(id = R.string.edit_profile),
            onClick = { onEvent(ProfileEvent.OnEditProfile) }
        )
        SpacerHeight(ExtraMediumSpacing)
        ProfileItemInfo(
            icon = Icons.Default.AccountBox,
            title = stringResource(id = R.string.type_users),
            onClick = { onEvent(ProfileEvent.OnEditUserType) }
        )
        SpacerHeight(ExtraMediumSpacing)
        ProfileItemInfo(
            icon = Icons.Default.Language,
            title = stringResource(id = R.string.language),
            onClick = { onEvent(ProfileEvent.OnEditLanguage) }
        )
    }
}