package com.example.animalsworldapp.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.AnimalsWorldApp.R

val Inter = FontFamily(Font(R.font.inter))
val LaBelle = FontFamily(Font(R.font.la_belle_aurore))
val NiramitMedium = FontFamily(Font(R.font.niramit_medium))
val NobileBoldItalic = FontFamily(Font(R.font.nobile_bold_italic))
val NobileMedium = FontFamily(Font(R.font.nobile_medium))
val LexendDeca = FontFamily(Font(R.font.lexend_deca))
val NobileBold = FontFamily(Font(R.font.nobile_bold))


val HK_GROTESK_FONTS = FontFamily(
    Font(R.font.hk_grotesk_regular, FontWeight.Normal),
    Font(R.font.hk_grotesk_semi_bold, FontWeight.SemiBold),
    Font(R.font.hk_grotesk_medium, FontWeight.Medium),
    Font(R.font.hk_grotesk_bold, FontWeight.Thin),
)

val Typography = Typography(

    displayLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 36.sp,
    ),
    displayMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 32.sp,
    ),
    headlineLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 26.sp,
    ),
    headlineSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
    ),

    titleLarge = TextStyle(
        fontFamily = HK_GROTESK_FONTS,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = HK_GROTESK_FONTS,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
    ),
    titleSmall = TextStyle(
        fontFamily = HK_GROTESK_FONTS,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
    ),

    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Light,
        fontSize = 16.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp,
    ),
)