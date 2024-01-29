package com.example.animalsworldapp.presentation.screens.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animalsworldapp.presentation.components.NoResultsStub
import com.example.animalsworldapp.presentation.components.TabBar
import com.example.animalsworldapp.presentation.extensions.SpacerHeight
import com.example.animalsworldapp.presentation.screens.all.components.ShowAllItem
import com.example.animalsworldapp.presentation.screens.common.LoadingScreen
import com.example.animalsworldapp.presentation.screens.detail.ItemDetailType
import com.example.animalsworldapp.presentation.theme.ExtraLargeSpacing
import com.example.animalsworldapp.presentation.theme.MediumSpacing


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    uiState: SearchUiState,
    navigateToDetails: (ItemDetailType, String) -> Unit,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(topBar = {
        TabBar(
            headline = "Search",
        )
    }) { innerPaddings ->
        Column(
            modifier = modifier
                .padding(innerPaddings)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
        ) {
            SpacerHeight(ExtraLargeSpacing)
            OutlinedTextField(
                value = uiState.query,
                onValueChange = onValueChange,
                textStyle = TextStyle(fontSize = 17.sp),
                shape = CircleShape,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = null,
                        tint = Color.Gray
                    )
                },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 26.dp)
                    .background(Color(0xFFE7F1F1), RoundedCornerShape(30.dp)),
                placeholder = { Text(text = "Start Search") },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.DarkGray,
                )
            )
            when {
                uiState.fauna.isEmpty() -> NoResultsStub()
                uiState.isLoading -> LoadingScreen()
                else -> {
                    LazyVerticalStaggeredGrid(
                        modifier = modifier
                            .padding(horizontal = MediumSpacing)
                            .padding(top = MediumSpacing),
                        columns = StaggeredGridCells.Fixed(2),
                        verticalItemSpacing = 4.dp,
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        content = {
                            items(items = uiState.fauna, key = { it.objectId }) { fauna ->
                                ShowAllItem(
                                    backgroundImage = fauna.backgroundImage,
                                    id = fauna.objectId,
                                    name = fauna.name,
                                    navigateToDetails = {
                                        navigateToDetails(ItemDetailType.FAUNA, it)
                                    },
                                    location = fauna.location
                                )
                            }
                        },
                    )
                }
            }
        }
    }
}
