package br.com.strfelix.recipes_manager_kotlin.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.com.strfelix.recipes_manager_kotlin.R

// Set of Material typography styles to start with
val poppinsFamily = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_semi_bold, FontWeight.SemiBold),
    Font(R.font.poppins_bold, FontWeight.Bold)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 40.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 36.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleSmall = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 100.sp,
        letterSpacing = 0.5.sp
    ),
    labelMedium = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 100.sp,
        letterSpacing = 0.5.sp
    ),
    displayLarge = TextStyle(
        fontFamily = poppinsFamily,
        letterSpacing = 0.5.sp,
        fontSize = 64.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 56.sp,
    )
)