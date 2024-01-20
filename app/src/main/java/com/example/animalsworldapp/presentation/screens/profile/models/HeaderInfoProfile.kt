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
import com.example.AnimalsWorldApp.R
import com.example.animalsworldapp.presentation.extensions.SpacerHeight
import com.example.animalsworldapp.presentation.models.User
import com.example.animalsworldapp.presentation.theme.ExtraLargeSpacing
import com.example.animalsworldapp.presentation.theme.LargeSpacing
import com.example.animalsworldapp.presentation.theme.MediumSpacing


@Composable
fun HeaderInfoProfile(
    user: User,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(ExtraLargeSpacing),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularImage(
                path = R.drawable.avatar_simple,
                modifier = Modifier, size = 150
            )
            SpacerHeight(LargeSpacing)
            Text(
                text = "Usenbaev",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold
            )
            SpacerHeight(MediumSpacing)
            Text(
                text = "Abubakir",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold
            )
            SpacerHeight(MediumSpacing)
            Text(
                text = "Abu",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold
            )
        }
    }
}