package com.example.animalsworldapp.presentation.screens.profile.models

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.animalsworldapp.presentation.extensions.SpacerHeight
import com.example.animalsworldapp.presentation.theme.ExtraLargeSpacing
import com.example.animalsworldapp.presentation.theme.LargeSpacing
import com.example.animalsworldapp.presentation.theme.MediumSpacing


@Composable
fun HeaderInfoProfile(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(ExtraLargeSpacing),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularImage(
                path = "uiState.user.avatar", modifier = Modifier, size = 150
            )
            SpacerHeight(LargeSpacing)
            Text(
                text = "Blake Gordon",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold
            )
            SpacerHeight(MediumSpacing)
            Text(
                text = "Bob",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold
            )
            SpacerHeight(MediumSpacing)
            Text(
                text = "Bio",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold
            )
        }
    }
}