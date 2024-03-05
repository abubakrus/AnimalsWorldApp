package com.example.animalsworldapp.presentation.screens.settigs.models

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAlarm
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.AnimalsWorldApp.R
import com.example.animalsworldapp.presentation.components.ThemeSwitcher
import com.example.animalsworldapp.presentation.theme.Black
import com.example.animalsworldapp.presentation.theme.ExtraLargeSpacing
import com.example.animalsworldapp.presentation.theme.ExtraMediumSpacing
import com.example.animalsworldapp.presentation.theme.Inter
import com.example.animalsworldapp.presentation.theme.Light_Gray
import com.example.animalsworldapp.presentation.theme.Light_White
import com.example.animalsworldapp.presentation.theme.MediumSpacing


@Composable
fun ProfileSwitchItem(
    icon: ImageVector? = null,
    title: String? = null,
    darkTheme: Boolean,
    onThemeUpdated: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = ExtraLargeSpacing)
            .clip(RoundedCornerShape(25.dp))
            .background(if (darkTheme) Light_Gray else Light_White),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (icon != null) Icon(
            modifier = Modifier
                .padding(start = ExtraMediumSpacing)
                .size(32.dp),
            imageVector = icon,
            contentDescription = null,
            tint = Black
        )
        if (title != null) {
            Text(
                modifier = Modifier
                    .padding(start = ExtraLargeSpacing),
                text = title,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontFamily = Inter,
                    color = Black
                )
            )
        }
        Spacer(modifier = Modifier.width(MediumSpacing))
        ThemeSwitcher(
            darkTheme = darkTheme,
            onClick = onThemeUpdated,
            size = 40.dp,
            padding = 5.dp,
        )
    }
}


@Composable
fun ProfileItemInfo(
    icon: ImageVector? = null,
    title: String? = null,
    onClick: (String) -> Unit,
    darkTheme: Boolean = false,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = ExtraLargeSpacing)
            .clip(RoundedCornerShape(25.dp))
            .background(if (darkTheme) Light_Gray else Light_White)
            .clickable { onClick(String()) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (icon != null) Icon(
            modifier = Modifier
                .padding(start = ExtraMediumSpacing)
                .size(32.dp),
            imageVector = icon,
            contentDescription = null,
            tint = Black
        )
        if (title != null) {
            Text(
                modifier = Modifier
                    .padding(start = ExtraLargeSpacing),
                text = title,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontFamily = Inter,
                    color = Black
                )
            )
        }
    }
}


@Preview
@Composable
fun ProfileItemInfoPreview() {
    MaterialTheme {
        ProfileItemInfo(
            icon = Icons.Default.AddAlarm,
            title = stringResource(id = R.string.type_users),
            onClick = {}
        )
    }
}