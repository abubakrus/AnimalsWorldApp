package com.example.animalsworldapp.presentation.screens.detail.models

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.AnimalsWorldApp.R
import com.example.animalsworldapp.presentation.theme.ExtraLargeSpacing
import com.example.animalsworldapp.presentation.theme.LargeSpacing
import com.example.animalsworldapp.presentation.theme.LexendDeca
import com.example.animalsworldapp.presentation.theme.MediumSpacing
import com.example.animalsworldapp.presentation.theme.Pink
import com.example.animalsworldapp.presentation.theme.SmallSpacing
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FloraDetailItem(
    modifier: Modifier = Modifier,
    backgroundImage: String,
    image: String,
    name: String,
    about: String,
    interestingFact: String?,
    navigateBackStack: () -> Unit,
) {
    val imageList = listOf(image, backgroundImage)
    val imageState = rememberPagerState { imageList.size }
    val detailTab = listOf(about, interestingFact)
    val pagerState = rememberPagerState(pageCount = { detailTab.size })
    val scope = rememberCoroutineScope()
    val scrollState = rememberScrollState()

    Box(
        modifier = modifier.fillMaxSize()
    ) {

        HorizontalPager(state = imageState) { index ->
            when (val list = imageList[index]) {
                imageList[0] -> {
                    AsyncImage(
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .height(480.dp)
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
                            .height(480.dp)
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
        Column(
            modifier = Modifier.padding(top = 490.dp, start = LargeSpacing, end = MediumSpacing)
        ) {
            Text(
                modifier = Modifier.padding(start = MediumSpacing, top = SmallSpacing),
                text = name,
                style = MaterialTheme.typography.displayMedium.copy(
                    color = MaterialTheme.colorScheme.onBackground, fontFamily = LexendDeca
                )
            )
            ScrollableTabRow(
                selectedTabIndex = pagerState.currentPage,
                modifier = modifier.padding(horizontal = 16.dp),
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
                    Tab(
                        modifier = Modifier
                            .padding(28.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        selected = index == pagerState.currentPage,
                        onClick = {
                            scope.launch { pagerState.animateScrollToPage(index) }
                        }) {
                        Text(
                            text = if (index == 0) {
                                stringResource(id = R.string.about)
                            } else {
                                stringResource(id = R.string.interestingFact)
                            },
                            style = MaterialTheme.typography.titleLarge,
                            color = if (isSystemInDarkTheme()) Color.White else Color.Black
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
                    detailTab[0] -> {
                        if (tab != null) {
                            Text(
                                modifier = Modifier.padding(top = MediumSpacing),
                                text = tab,
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    color = MaterialTheme.colorScheme.onBackground,
                                    fontFamily = LexendDeca
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
                                    fontFamily = LexendDeca
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}