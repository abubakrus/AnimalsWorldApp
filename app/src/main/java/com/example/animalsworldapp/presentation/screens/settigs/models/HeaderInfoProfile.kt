package com.example.animalsworldapp.presentation.screens.settigs.models

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.AnimalsWorldApp.R
import com.example.animalsworldapp.presentation.extensions.SpacerHeight
import com.example.animalsworldapp.presentation.theme.ExtraLargeSpacing
import com.example.animalsworldapp.presentation.theme.LargeSpacing


@Composable
fun HeaderInfoProfile(
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
                path = R.drawable.paw,
                modifier = Modifier, size = 200
            )
            SpacerHeight(LargeSpacing)
        }
    }
}