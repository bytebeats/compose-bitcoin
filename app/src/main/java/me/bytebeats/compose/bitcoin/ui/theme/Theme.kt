package me.bytebeats.compose.bitcoin.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    onPrimary = White,
    secondary = Teal200,
    secondaryVariant = Teal200,
    onSecondary = Black,
    surface = Black,
    onSurface = White,
    background = Black,
    onBackground = White,
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    onPrimary = White,
    secondary = Teal200,
    secondaryVariant = Teal700,
    onSecondary = Black,
    surface = White,
    onSurface = Black,
    background = White,
    onBackground = Black,
)

@Composable
fun ComposeBitcoinTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}