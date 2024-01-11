package com.example.animalsworldapp.presentation.screens.detail.models

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.animalsworldapp.presentation.models.Fauna
import com.example.animalsworldapp.presentation.theme.DarkPlaceholder
import com.example.animalsworldapp.presentation.theme.ExtraLargeSpacing
import com.example.animalsworldapp.presentation.theme.ExtraMediumSpacing
import com.example.animalsworldapp.presentation.theme.LexendDeca
import com.example.animalsworldapp.presentation.theme.LightPlaceholder

@Composable
fun DetailScreenHeader(
    modifier: Modifier = Modifier,
    fauna: Fauna
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(500.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(380.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomStart = 25.dp,
                        bottomEnd = 25.dp
                    )
                )
                .background(
                    if (isSystemInDarkTheme()) LightPlaceholder
                    else DarkPlaceholder
                ),
            model = fauna.backgroundImage,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        AsyncImage(
            modifier = Modifier
                .padding(start = ExtraMediumSpacing)
                .align(Alignment.BottomStart)
                .width(150.dp)
                .height(190.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(
                    if (isSystemInDarkTheme()) LightPlaceholder
                    else DarkPlaceholder
                ),
            model = fauna.image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = ExtraLargeSpacing),
            text = fauna.name,
            style = MaterialTheme.typography.headlineSmall,
            fontFamily = LexendDeca,
            color = MaterialTheme.colorScheme.onBackground,

            )
    }
}

@Preview
@Composable
fun DetailScreenHeaderPreview() {
    MaterialTheme {
        DetailScreenHeader(fauna = Fauna.unknown)
    }
}