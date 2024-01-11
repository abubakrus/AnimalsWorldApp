package com.example.animalsworldapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animalsworldapp.presentation.extensions.SpacerHeight
import com.example.animalsworldapp.presentation.theme.Blue
import com.example.animalsworldapp.presentation.theme.Dark_Black
import com.example.animalsworldapp.presentation.theme.LargeSpacing
import com.example.animalsworldapp.presentation.theme.MediumSpacing


@Composable
fun EditTextField(
    value: String,
    hint: String,
    topText: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    fieldModifier: Modifier = Modifier,
    isSingleLine: Boolean = true
) {
    Column(
        modifier = modifier
    ) {
        val gray = Dark_Black.copy(alpha = 0.5f)
        Text(
            modifier = fieldModifier,
            text = topText.uppercase(),
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = gray
        )
        SpacerHeight(MediumSpacing)
        TextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = isSingleLine,
            modifier = fieldModifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                disabledContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,

                disabledIndicatorColor = gray,
                focusedIndicatorColor = Blue,
                unfocusedIndicatorColor = gray,
            ),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Bold
            ),
            placeholder = {
                Text(
                    text = hint,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                    color = gray
                )
            },
            trailingIcon = {
                if (value.isNotEmpty()) Icon(
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { onValueChange(String()) },
                    imageVector = Icons.Default.Clear,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        )
    }
}


@Preview
@Composable
fun EditTextFieldPreview() {
    MaterialTheme {
        EditTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.background(Dark_Black),
            topText = "",
            hint = "asnocnokacs",
            fieldModifier = Modifier.padding(horizontal = LargeSpacing)
        )
    }
}