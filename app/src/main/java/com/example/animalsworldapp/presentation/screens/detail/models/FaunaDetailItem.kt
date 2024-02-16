package com.example.animalsworldapp.presentation.screens.detail.models

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material.icons.outlined.KeyboardVoice
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import coil.compose.AsyncImage
import com.example.AnimalsWorldApp.R
import com.example.animalsworldapp.presentation.theme.ExtraLargeSpacing
import com.example.animalsworldapp.presentation.theme.ExtraMediumSpacing
import com.example.animalsworldapp.presentation.theme.LargeSpacing
import com.example.animalsworldapp.presentation.theme.LexendDeca
import com.example.animalsworldapp.presentation.theme.MediumSpacing
import com.example.animalsworldapp.presentation.theme.NiramitMedium
import com.example.animalsworldapp.presentation.theme.Pink
import com.example.animalsworldapp.presentation.theme.SmallSpacing
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FaunaDetailItem(
    onClickVoice: () -> Unit,
    backgroundImage: String,
    location: String,
    name: String,
    image: String,
    locationImage: String,
    animalsClasses: String,
    about: String,
    videoUri: String,
    interestingFact: String?,
    navigateBackStack: () -> Unit,
    modifier: Modifier = Modifier,
    navigateToLocation: (String) -> Unit,

    ) {
    val imageList = listOf(image, backgroundImage, locationImage)
    val imageState = rememberPagerState { imageList.size }
    val detailTab = listOf(about, interestingFact, videoUri)
    val pagerState = rememberPagerState(pageCount = { detailTab.size })
    val scope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        HorizontalPager(state = imageState) { index ->
            when (val list = imageList[index]) {
                imageList[0] -> {
                    AsyncImage(
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .height(520.dp)
                            .fillMaxWidth()
                            .padding(MediumSpacing)
                            .clip(RoundedCornerShape(35.dp)),
                        model = list,
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }

                imageList[1] -> {
                    AsyncImage(
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .height(520.dp)
                            .fillMaxWidth()
                            .padding(MediumSpacing)
                            .clip(RoundedCornerShape(35.dp)),
                        model = list,
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }

                imageList.last() -> {
                    AsyncImage(
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .height(520.dp)
                            .fillMaxWidth()
                            .padding(MediumSpacing)
                            .clip(RoundedCornerShape(35.dp)),
                        model = list,
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
        IconButton(modifier = Modifier
            .align(Alignment.TopStart)
            .padding(ExtraLargeSpacing)
            .clip(CircleShape)
            .background(Color.Transparent.copy(alpha = 0.25f)),
            onClick = { navigateBackStack() }) {
            Icon(
                modifier = Modifier.size(22.dp),
                imageVector = Icons.Outlined.ArrowBackIosNew,
                contentDescription = null,
                tint = Color.White
            )
        }
        IconButton(modifier = Modifier
            .align(Alignment.TopEnd)
            .padding(ExtraLargeSpacing)
            .clip(CircleShape)
            .background(Color.Transparent.copy(alpha = 0.25f)),
            onClick = { onClickVoice() }) {
            Icon(
                modifier = Modifier.size(22.dp),
                imageVector = Icons.Outlined.KeyboardVoice,
                contentDescription = null,
                tint = Color.White
            )
        }
        Column(
            modifier = Modifier
                .padding(top = 525.dp)
                .padding(horizontal = LargeSpacing),
            horizontalAlignment = Alignment.Start,
        ) {
            Row(
                modifier = Modifier
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = null,
                    tint = Pink
                )
                Text(
                    text = location, style = MaterialTheme.typography.bodyLarge.copy(
                        color = Pink, fontFamily = LexendDeca
                    ),
                    modifier = Modifier.clickable { navigateToLocation(location) }
                )
            }

            Text(
                modifier = Modifier.padding(start = SmallSpacing),
                text = name,
                style = MaterialTheme.typography.displayMedium.copy(
                    color = MaterialTheme.colorScheme.onBackground, fontFamily = LexendDeca
                )
            )
            Text(
                modifier = Modifier.padding(start = SmallSpacing),
                text = animalsClasses,
                style = MaterialTheme.typography.titleMedium.copy(
                    color = MaterialTheme.colorScheme.onBackground, fontFamily = LexendDeca
                )
            )
            ScrollableTabRow(
                selectedTabIndex = pagerState.currentPage,
                modifier = modifier.padding(horizontal = 12.dp),
                indicator = { tabPositions ->
                    Box(
                        modifier = Modifier
                            .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                            .height(4.dp)
                            .background(
                                color = MaterialTheme.colorScheme.onBackground,
                                shape = RoundedCornerShape(8.dp)
                            )
                    )
                },
                divider = {
                    Spacer(modifier = Modifier.height(4.dp))
                },
                edgePadding = 0.dp,
            ) {
                detailTab.forEachIndexed { index, detailTab ->
                    Tab(modifier = Modifier
                        .padding(MediumSpacing)
                        .clip(RoundedCornerShape(16.dp))
                        .padding(ExtraMediumSpacing),
                        selected = index == pagerState.currentPage,
                        onClick = {
                            scope.launch { pagerState.animateScrollToPage(index) }
                        }) {
                        Text(
                            text = when (index) {
                                0 -> {
                                    stringResource(id = R.string.about)
                                }
                                1 -> {
                                    stringResource(id = R.string.interestingFact)
                                }
                                else -> {
                                    stringResource(id = R.string.view)
                                }
                            },
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontFamily = LexendDeca
                            ),
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }

                }
            }
            HorizontalPager(
                modifier = Modifier
                    .fillMaxWidth()
                    .nestedScroll(remember {
                        object : NestedScrollConnection {
                            override fun onPreScroll(
                                available: Offset, source: NestedScrollSource
                            ): Offset {
                                return if (available.y > 0) Offset.Zero else Offset(
                                    x = 0f, y = -scrollState.dispatchRawDelta(-available.y)
                                )
                            }
                        }
                    }),
                state = pagerState,
            ) { index ->
                when (val tab = detailTab[index]) {
                    detailTab.first() -> {
                        if (tab != null) {
                            Text(
                                modifier = Modifier.padding(top = MediumSpacing),
                                text = tab,
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    color = MaterialTheme.colorScheme.onBackground,
                                    fontFamily = NiramitMedium
                                )
                            )
                        }
                    }

                    detailTab[1] -> {
                        if (tab != null) {
                            Text(
                                modifier = Modifier.padding(top = MediumSpacing),
                                text = tab,
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    color = MaterialTheme.colorScheme.onBackground,
                                    fontFamily = NiramitMedium
                                )
                            )
                        }
                    }
                    detailTab.last() -> {
                        if (tab != null) {
                            VideoPlayer(
                                videoUri = videoUri,
                                lifecycleOwner = LocalLifecycleOwner.current
                            )
                        }
                    }
                }
            }
        }
    }
}
