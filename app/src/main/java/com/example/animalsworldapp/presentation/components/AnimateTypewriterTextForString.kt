package com.example.animalsworldapp.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.animalsworldapp.presentation.theme.Inter
import com.example.animalsworldapp.presentation.theme.LaBelle
import com.example.animalsworldapp.presentation.theme.LexendDeca
import kotlinx.coroutines.delay

@Composable
fun AnimateTypewriterTextForString(
    modifier: Modifier = Modifier,
    baseText: String,
    highlightText: String,
    parts: List<String>,
) {
    val highlightStart = baseText.indexOf(highlightText)
    var partIndex by remember { mutableStateOf(0) }
    var partText by remember { mutableStateOf("") }
    val textToDisplay = "$baseText$partText"
    var selectedPartReacts by remember { mutableStateOf(listOf<Rect>()) }

    LaunchedEffect(key1 = parts) {
        while (partIndex <= parts.size) {
            val part = parts[partIndex]
            part.forEachIndexed { charIndex, _ ->
                partText = part.substring(startIndex = 0, endIndex = charIndex + 1)
                partText += ""
                delay(100)
            }
            delay(3000)
            part.forEachIndexed { charIndex, _ ->
                partText = part.substring(startIndex = 0, endIndex = part.length - (charIndex + 1))
                partText += ""
                delay(30)
            }
            delay(4000)
            partIndex = (partIndex + 1) % parts.size
        }
    }

    Text(
        text = textToDisplay,
        style = MaterialTheme.typography.headlineLarge,
        color = Color.White,
        fontSize = 45.sp,
        fontFamily = LexendDeca,
        fontWeight = FontWeight.Black,
        modifier = Modifier.then(modifier),
        onTextLayout = { layoutResult ->
            val start = baseText.length
            val end = textToDisplay.count()
            selectedPartReacts = if (start < end) {
                layoutResult.getBoundingBoxesForRange(start = start, end = end - 1)
            } else {
                emptyList()
            }

            if (highlightStart >= 0) {
                selectedPartReacts = selectedPartReacts + layoutResult.getBoundingBoxesForRange(
                    start = highlightStart, end = highlightStart + highlightText.length
                )
            }
        })
}
