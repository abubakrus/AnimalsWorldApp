package com.example.animalsworldapp.presentation.screens.profile.models

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


private const val DEFAULT_IMAGE_SIZE = 40

@Composable
fun CircularImage(
    path: Any?,
    size: Int = DEFAULT_IMAGE_SIZE,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        modifier = modifier
            .size(size.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.secondary),
        model = path,
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}
