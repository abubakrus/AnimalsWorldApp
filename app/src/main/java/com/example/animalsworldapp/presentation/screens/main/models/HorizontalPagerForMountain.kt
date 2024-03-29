package com.example.animalsworldapp.presentation.screens.main.models

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.AnimalsWorldApp.R
import com.example.animalsworldapp.presentation.extensions.SpacerHeight
import com.example.animalsworldapp.presentation.models.Mountain
import com.example.animalsworldapp.presentation.theme.DarkPlaceholder
import com.example.animalsworldapp.presentation.theme.Dark_Gray
import com.example.animalsworldapp.presentation.theme.ExtraLargeSpacing
import com.example.animalsworldapp.presentation.theme.ExtraMediumSpacing
import com.example.animalsworldapp.presentation.theme.ExtraSmallSpacing
import com.example.animalsworldapp.presentation.theme.LightPlaceholder
import com.example.animalsworldapp.presentation.theme.Light_Gray
import com.example.animalsworldapp.presentation.theme.MediumSpacing
import com.example.animalsworldapp.presentation.theme.NobileMedium


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerForMountain(
    mountainList: List<Mountain>,
    navigateToDetails: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val pagerState = rememberPagerState(pageCount = { mountainList.size })
    Box(
        modifier = Modifier
            .padding(bottom = ExtraSmallSpacing, top = MediumSpacing)
            .padding(horizontal = ExtraLargeSpacing)
    ) {
        HorizontalPager(
            modifier = Modifier,
            state = pagerState,
        ) { index ->
            val mountain = mountainList[index]
            Box(modifier = Modifier) {
                val pageOffset =
                    (pagerState.currentPage - index) + pagerState.currentPageOffsetFraction
                val imageSize by animateFloatAsState(
                    targetValue = if (pageOffset != 0.0f) 0.75f else 1f,
                    animationSpec = tween(durationMillis = 300),
                    label = ""
                )
                val infobox by animateFloatAsState(
                    targetValue = if (pageOffset != 0.0f) 0f else 1f,
                    animationSpec = tween(durationMillis = 300),
                    label = ""
                )
                AsyncImage(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .graphicsLayer {
                            scaleX = imageSize
                            scaleY = imageSize
                        }
                        .clip(RoundedCornerShape(16.dp))
                        .background(
                            if (isSystemInDarkTheme()) DarkPlaceholder
                            else LightPlaceholder
                        )
                        .clickable { navigateToDetails(mountain.id) },
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(mountain.backgroundImage).build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = if (isSystemInDarkTheme()) R.drawable.dark_image_place_holder else R.drawable.light_image_place_holder)

                )
                Column(modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .width(340.dp)
                    .height(100.dp)
                    .graphicsLayer {
                        scaleX = infobox
                        scaleY = infobox
                    }
                    .padding(bottom = ExtraMediumSpacing)
                    .padding(horizontal = MediumSpacing)
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color.White)
                    .padding(horizontal = ExtraLargeSpacing),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start) {
                    Text(
                        modifier = Modifier,
                        text = mountain.name,
                        style = MaterialTheme.typography.titleLarge.copy(
                            color = Dark_Gray, fontFamily = NobileMedium
                        )
                    )
                    SpacerHeight(MediumSpacing)
                    Row(
                        modifier = Modifier
                    ) {
                        Icon(
                            modifier = Modifier.size(22.dp),
                            imageVector = Icons.Filled.LocationOn,
                            contentDescription = null,
                            tint = Light_Gray
                        )
                        Text(
                            text = mountain.location, style = MaterialTheme.typography.titleMedium.copy(
                                color = Dark_Gray, fontFamily = NobileMedium
                            )
                        )
                    }
                }
            }
        }
    }
}