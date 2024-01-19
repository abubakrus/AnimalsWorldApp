package com.example.animalsworldapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.animalsworldapp.presentation.models.Forest
import com.example.animalsworldapp.presentation.theme.LargeSpacing
import com.example.animalsworldapp.presentation.theme.NobileBold
import com.example.animalsworldapp.presentation.theme.SmallSpacing


@Composable
fun AllForestItem(
    forest: Forest,
    navigateToDetails: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        AsyncImage(
            model = forest.backgroundImage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = SmallSpacing)
                .clip(
                    RoundedCornerShape(
                        topStart = 16.dp, topEnd = 16.dp, bottomStart = 16.dp, bottomEnd = 16.dp
                    )
                )
                .clickable { navigateToDetails(forest.id) },
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(40.dp)
                .padding(bottom = SmallSpacing)
                .padding(horizontal = LargeSpacing)
                .clip(RoundedCornerShape(25.dp))
                .background(Color.White.copy(alpha = 0.5f)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                modifier = Modifier.padding(SmallSpacing),
                text = forest.name,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 14.sp, color = Color.Black, fontFamily = NobileBold
                )
            )
        }
    }
}