package com.example.animalsworldapp.presentation.screens.saved.models

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.animalsworldapp.presentation.models.Mountain
import com.example.animalsworldapp.presentation.theme.DarkPlaceholder
import com.example.animalsworldapp.presentation.theme.ExtraLargeSpacing
import com.example.animalsworldapp.presentation.theme.LightPlaceholder
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerWithIndicators(
    mountain: List<Mountain>,
    modifier: Modifier = Modifier,

    ) {
    val scope = rememberCoroutineScope()
    Box(modifier = modifier) {
        val pageCount = 7
        val pagerState = rememberPagerState(pageCount = { pageCount })
        LaunchedEffect(Unit) {
            while (true) {
                delay(4000)
                val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
                scope.launch {
                    pagerState.animateScrollToPage(
                        nextPage,
                        animationSpec = tween(300)
                    )
                }
            }
        }
        HorizontalPager(
            beyondBoundsPageCount = 2,
            state = pagerState,
        ) { position ->
            AsyncImage(
                model = mountain[position].backgroundImage,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(start = ExtraLargeSpacing, end = ExtraLargeSpacing)
                    .fillMaxWidth()
                    .height(260.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .clickable {}
                    .background(
                        if (isSystemInDarkTheme()) DarkPlaceholder
                        else LightPlaceholder
                    ),
            )
        }
        Row(
            Modifier
                .height(50.dp)
                .fillMaxWidth()
                .padding(top = 24.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) Color.White else Color.White.copy(alpha = 0.5f)
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(12.dp)
                )
            }
        }
    }
}
