package com.example.animalsworldapp.presentation.screens.main.models

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.animalsworldapp.presentation.extensions.shimmerLoadingAnimation
import com.example.animalsworldapp.presentation.theme.ExtraLargeSpacing
import com.example.animalsworldapp.presentation.theme.MediumSpacing
import com.example.animalsworldapp.presentation.theme.SmallSpacing

@Composable
fun LoadingScreenMain(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        FloraBox()
        HeadingTextBox()
        FaunaBox()
        HeadingTextBox()
        MountainBox()
        ForestBox()
    }
}

@Composable
fun FloraBox(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(horizontal = ExtraLargeSpacing)
            .fillMaxWidth()
            .height(260.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(color = Color.LightGray)
            .shimmerLoadingAnimation()
    )
}

@Composable
fun HeadingTextBox(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(top = ExtraLargeSpacing + MediumSpacing)
            .padding(horizontal = ExtraLargeSpacing)
            .fillMaxWidth()
            .height(35.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(color = Color.LightGray)
            .shimmerLoadingAnimation(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {}
}

@Composable
fun FaunaBox(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(450.dp)
            .padding(horizontal = SmallSpacing)
            .padding(16.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 16.dp, topEnd = 16.dp, bottomStart = 25.dp, bottomEnd = 25.dp
                )
            )
            .background(color = Color.LightGray)
            .shimmerLoadingAnimation()
    )
}

@Composable
fun MountainBox(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = Color.LightGray)
            .shimmerLoadingAnimation()
    )
}

@Composable
fun ForestBox(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = Color.LightGray)
            .shimmerLoadingAnimation()
    )
}