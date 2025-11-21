package net.timlin.twoweeksapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.runtime.Composable

import androidx.compose.ui.tooling.preview.Preview

import net.timlin.twoweeksapp.ui.theme.TwoWeeksAppTheme
import net.timlin.twoweeksapp.ui.theme.VitalsReleaseApp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            TwoWeeksAppTheme {
                VitalsReleaseApp()
            }
        }
    }


}


@Preview(showBackground = true)
@Composable
fun TwoWeeksPreview() {
    TwoWeeksAppTheme {
        VitalsReleaseApp()
    }
}