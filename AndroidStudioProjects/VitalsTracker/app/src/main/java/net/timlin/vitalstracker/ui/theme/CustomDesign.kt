package net.timlin.vitalstracker.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle


data class AppColorTheme(
    val background: Color,
    val onBackground:Color,
    val primary: Color,
    val onPrimary:Color,
    val secondary: Color,
    val onSecondary:Color
    )

data class AppTypography(
    val titleLarge: TextStyle,
    val titleNormal: TextStyle,

    )

val LocalAppColorScheme= staticCompositionLocalOf {
    AppColorTheme(
        background = Color.Unspecified,
        onBackground = Color.Unspecified,
        primary = Color.Unspecified,
        onPrimary = Color.Unspecified,
        secondary = Color.Unspecified,
        onSecondary = Color.Unspecified,
    )

}
