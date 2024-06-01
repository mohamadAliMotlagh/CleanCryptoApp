package com.app.exzi.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.app.exzi.R

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = montserratFont,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.5.sp
    ),
    bodySmall = TextStyle(
        fontFamily = montserratFont,
        fontWeight = FontWeight.Normal,
        fontSize = 9.5.sp,
        lineHeight = 11.58.sp,
        letterSpacing = (-0.5).sp
    ),

    bodyMedium = TextStyle(
        fontFamily = montserratFont,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        lineHeight = 13.41.sp,
    ),
    headlineSmall = TextStyle(
        fontFamily = montserratFont,
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp,
        lineHeight = 31.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = montserratFont,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        lineHeight = 15.85.sp,
    )
)