package com.example.animalsworldapp.presentation.screens.detail.models

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.animalsworldapp.presentation.extensions.shimmerLoadingAnimation
import com.example.animalsworldapp.presentation.theme.ExtraLargeSpacing
import com.example.animalsworldapp.presentation.theme.ExtraMediumSpacing
import com.example.animalsworldapp.presentation.theme.ExtraSmallSpacing
import com.example.animalsworldapp.presentation.theme.LargeSpacing
import com.example.animalsworldapp.presentation.theme.MediumSpacing
import com.example.animalsworldapp.presentation.theme.SmallSpacing


@Composable
fun LoadingScreenDetail(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().statusBarsPadding()
    ) {
        HeaderBox()
        NameBox()
        LocationBox()
        TextBox()
        TextBox()
        TextBox()
        TextBox()
    }
}

@Composable
fun HeaderBox(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(480.dp)
            .fillMaxWidth()
            .padding(MediumSpacing)
            .clip(RoundedCornerShape(35.dp))
            .background(color = Color.LightGray)
            .shimmerLoadingAnimation()
    )
}


@Composable
fun NameBox(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(start = MediumSpacing, top = SmallSpacing)
            .width(90.dp)
            .height(35.dp)
            .clip(RoundedCornerShape(35.dp))
            .background(color = Color.LightGray)
            .shimmerLoadingAnimation()
    )
}

@Composable
fun LocationBox(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(
                start = LargeSpacing, end = MediumSpacing, top = ExtraMediumSpacing
            )
            .width(170.dp)
            .height(35.dp)
            .clip(RoundedCornerShape(35.dp))
            .background(color = Color.LightGray)
            .shimmerLoadingAnimation()
    )
}

@Composable
fun TextBox(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(top = ExtraSmallSpacing)
            .padding(horizontal = ExtraLargeSpacing)
            .fillMaxWidth()
            .height(35.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(color = Color.LightGray)
            .shimmerLoadingAnimation(),
    )
}