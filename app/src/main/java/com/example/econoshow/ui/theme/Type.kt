package com.example.econoshow.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.econoshow.R

val Raleway = FontFamily(
    Font(R.font.raleway_light, weight = FontWeight.Light, style = FontStyle.Normal),
    Font(R.font.raleway_lightitalic, weight = FontWeight.Light, style = FontStyle.Italic),
    Font(R.font.raleway_medium, weight = FontWeight.Medium, style = FontStyle.Normal),
    Font(R.font.raleway_mediumitalic, weight = FontWeight.Medium, style = FontStyle.Italic),
    Font(R.font.raleway_bold, weight = FontWeight.Bold, style = FontStyle.Normal),
    Font(R.font.raleway_bolditalic, weight = FontWeight.Bold, style = FontStyle.Italic)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    displayMedium = TextStyle(
        fontFamily = Raleway,
        fontWeight = FontWeight.Medium,
        fontSize = 70.sp,
        lineHeight = 78.sp,
        letterSpacing = 0.sp,
    ),
    displayLarge = TextStyle(
        fontFamily = Raleway,
        fontWeight = FontWeight.Bold,
        fontSize = 100.sp,
        lineHeight = 120.sp,
        letterSpacing = 0.sp,
    )

)