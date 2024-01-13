package com.example.animalsworldapp.presentation.screens.detail_fauna.models

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardVoice
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.animalsworldapp.presentation.models.Fauna
import com.example.animalsworldapp.presentation.theme.ExtraLargeSpacing
import com.example.animalsworldapp.presentation.theme.LargeSpacing
import com.example.animalsworldapp.presentation.theme.LexendDeca
import com.example.animalsworldapp.presentation.theme.MediumSpacing
import com.example.animalsworldapp.presentation.theme.Pink
import com.example.animalsworldapp.presentation.theme.SmallSpacing


@Composable
fun FaunaDetailItem(
    fauna: Fauna,
    navigateBackStack: () -> Unit,
    onClickVoice: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        AsyncImage(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .height(480.dp)
                .fillMaxWidth()
                .padding(MediumSpacing)
                .clip(RoundedCornerShape(35.dp)),
            model = fauna.backgroundImage,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
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
                    text = fauna.location, style = MaterialTheme.typography.bodyLarge.copy(
                        color = Pink, fontFamily = LexendDeca
                    )
                )
            }
            Text(
                modifier = Modifier.padding(start = MediumSpacing, top = SmallSpacing),
                text = fauna.name,
                style = MaterialTheme.typography.displayMedium.copy(
                    color = MaterialTheme.colorScheme.onBackground, fontFamily = LexendDeca
                )
            )
            Text(
                modifier = Modifier.padding(top = MediumSpacing),
                text = fauna.aboutFauna,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.onBackground, fontFamily = LexendDeca
                )
            )
            Card(
                modifier = Modifier
                    .size(45.dp)
                    .clickable { onClickVoice() }
                    .clip(CircleShape),
                shape = CardDefaults.shape,
            ) {
                Icon(
                    modifier = Modifier,
                    imageVector = Icons.Default.KeyboardVoice,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.background
                )
            }
        }
    }
}