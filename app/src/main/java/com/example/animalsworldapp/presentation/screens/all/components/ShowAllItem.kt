package com.example.animalsworldapp.presentation.screens.all.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.AnimalsWorldApp.R
import com.example.animalsworldapp.presentation.theme.Dark_Gray
import com.example.animalsworldapp.presentation.theme.ExtraMediumSpacing
import com.example.animalsworldapp.presentation.theme.LexendDeca
import com.example.animalsworldapp.presentation.theme.Light_Gray
import com.example.animalsworldapp.presentation.theme.NobileBold
import com.example.animalsworldapp.presentation.theme.SmallSpacing


@Composable
fun ShowAllItem(
    backgroundImage: String,
    id: String,
    name: String,
    location: String,
    navigateToDetails: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        AsyncImage(
            model = backgroundImage,
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
                .clickable { navigateToDetails(id) },
            placeholder = painterResource(id = if (isSystemInDarkTheme()) R.drawable.dark_image_place_holder else R.drawable.light_image_place_holder)
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(70.dp)
                .padding(bottom = SmallSpacing)
                .padding(horizontal = ExtraMediumSpacing)
                .clip(RoundedCornerShape(15.dp))
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                modifier = Modifier.padding(SmallSpacing),
                text = name,
                style = MaterialTheme.typography.bodySmall.copy(
                    color = Dark_Gray, fontFamily = NobileBold
                )
            )
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = null,
                    tint = Light_Gray
                )
                Text(
                    text = location,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Dark_Gray, fontFamily = LexendDeca
                    )
                )
            }
        }
    }
}