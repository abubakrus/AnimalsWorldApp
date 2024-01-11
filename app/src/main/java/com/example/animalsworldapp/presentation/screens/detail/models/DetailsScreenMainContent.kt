package com.example.animalsworldapp.presentation.screens.detail.models

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.animalsworldapp.presentation.models.Fauna


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailsScreenMainContent(
    modifier: Modifier = Modifier,
    fauna: Fauna
) {
    val scrollState = rememberScrollState()
    val pagerState = rememberPagerState(pageCount = { 4 })

    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        containerColor = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth(),
        indicator = { tabPositions ->
            Box(
                modifier = Modifier
//                                .tabIndicatorOffset(tabPositions[pagerState.currentPage])
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
        edgePadding = 0.dp
    ) {

    }
    HorizontalPager(
        state = pagerState,
        modifier = Modifier.background(MaterialTheme.colorScheme.background),
        userScrollEnabled = false
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
        }
    }
}