package com.example.cardsflash.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.cardsflash.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
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
    )
    */
)

//val lexendFontFamily = FontFamily(Font(R.font.lexend_variable,))

val lexendFontFamily = FontFamily(
    Font(R.font.lexend_variable, FontWeight.W300),
    Font(R.font.lexend_variable, FontWeight.W500),
    Font(R.font.lexend_variable, FontWeight.W700),
    )

val brshapeFontFamily = FontFamily(
    Font(R.font.brshape_reg, FontWeight.Normal),
    Font(R.font.brshape_med, FontWeight.Medium),
    Font(R.font.brshape_sbold, FontWeight.SemiBold),
    )