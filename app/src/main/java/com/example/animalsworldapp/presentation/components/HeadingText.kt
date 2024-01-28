package com.example.animalsworldapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.AnimalsWorldApp.R
import com.example.animalsworldapp.presentation.theme.ExtraLargeSpacing
import com.example.animalsworldapp.presentation.theme.LexendDeca
import com.example.animalsworldapp.presentation.theme.MediumSpacing


@Composable
fun HeadingText(
    text: String,
    modifier: Modifier = Modifier,
    isShowAll: Boolean = true,
    navigateToAllShow: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(top = ExtraLargeSpacing)
            .padding(horizontal = ExtraLargeSpacing)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = text,
            style = MaterialTheme.typography.titleSmall.copy(
                fontFamily = LexendDeca,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onBackground
            )

        )
        if (isShowAll) Text(
            modifier = Modifier
                .padding(end = MediumSpacing)
                .clickable { navigateToAllShow() },
            text = stringResource(id = R.string.show_all),
            fontFamily = LexendDeca,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.primary
        )
    }
}