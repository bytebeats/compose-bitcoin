package me.bytebeats.compose.bitcoin.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = FontFamily.SansSerif,
    h1 = TextStyle(fontSize = 64.sp, fontWeight = FontWeight.Black),
    h2 = TextStyle(fontSize = 48.sp, fontWeight = FontWeight.Black),
    h3 = TextStyle(fontSize = 36.sp, fontWeight = FontWeight.Bold),
    h4 = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
    h5 = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
    h6 = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
    body1 = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
    body2 = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Medium),
    subtitle1 = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
    subtitle2 = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Medium),
    button = TextStyle(fontWeight = FontWeight.Medium),
    overline = TextStyle(fontWeight = FontWeight.Medium),
)