package com.example.animalsworldapp.presentation.screens.all.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animalsworldapp.presentation.extensions.shimmerLoadingAnimation
import com.example.animalsworldapp.presentation.theme.ExtraSmallSpacing
import com.example.animalsworldapp.presentation.theme.ExtraSpacing
import com.example.animalsworldapp.presentation.theme.MediumSpacing
import com.example.animalsworldapp.presentation.theme.SmallSpacing


@Composable
fun LoadingScreenForAllShow(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .statusBarsPadding()
            .padding(top = ExtraSpacing+ExtraSpacing)
            .padding(horizontal = MediumSpacing)
    ) {
        Column {
            ShowAllShimmer()
            Spacer(modifier = Modifier.height(ExtraSmallSpacing))
            ShowAllShimmer(modifier = Modifier.height(260.dp))
            Spacer(modifier = Modifier.height(ExtraSmallSpacing))
            ShowAllShimmer(modifier = Modifier.height(240.dp))
            Spacer(modifier = Modifier.height(ExtraSmallSpacing))
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            ShowAllShimmer()
            Spacer(modifier = Modifier.height(ExtraSmallSpacing))
            ShowAllShimmer(modifier = Modifier.height(280.dp))
            Spacer(modifier = Modifier.height(ExtraSmallSpacing))
            ShowAllShimmer(modifier = Modifier.height(240.dp))
            Spacer(modifier = Modifier.height(ExtraSmallSpacing))
        }
    }
}


@Composable
fun ShowAllShimmer(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(200.dp)
            .height(220.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(color = Color.LightGray)
            .shimmerLoadingAnimation()
    )
}


@Preview
@Composable
fun ShowAllShimmerPreview() {
    MaterialTheme {
        ShowAllShimmer()
    }
}