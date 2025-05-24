package com.example.myapplication.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFF006C51),
    secondary = Color(0xFF4CAF50),
    tertiary = Color(0xFF03A9F4)
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFF4CAF50),
    secondary = Color(0xFF03A9F4),
    tertiary = Color(0xFFFFC107)
)

@Composable
fun LumiSmartTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}