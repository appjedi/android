package net.timlin.vitalstracker.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

private val darkColorScheme= AppColorTheme(
    background = Color.Black,
    onBackground = Color.DarkGray,
    primary = Color.Magenta,
    onPrimary = Color.Cyan,
    secondary = Color.Green,
    onSecondary = Color.LightGray,
)
private val lightColorScheme= AppColorTheme(
    background = Color.White,
    onBackground = Color.LightGray,
    primary = Color.Magenta,
    onPrimary = Color.Cyan,
    secondary = Color.Green,
    onSecondary = Color.LightGray,
)

@Composable
fun AppTheme(
    isDarkTheme: Boolean= isSystemInDarkTheme(),
    content: @Composable () -> Unit
){
    val colorScheme=if(isDarkTheme)darkColorScheme else lightColorScheme
    //val rippleIndication= rememberRipple()
    CompositionLocalProvider(
        LocalAppColorScheme provides colorScheme,
        content=content

    ) { }
}

object AppTheme{
    val colorScheme: AppColorTheme
        @Composable get() = LocalAppColorScheme.current


}