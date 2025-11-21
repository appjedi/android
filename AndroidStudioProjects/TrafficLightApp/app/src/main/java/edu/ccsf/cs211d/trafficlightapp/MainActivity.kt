package edu.ccsf.cs211d.trafficlightapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import edu.ccsf.cs211d.trafficlightapp.ui.theme.TrafficLightAppTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.material3.Button
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrafficLightAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TrafficLightApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Preview
@Composable
fun TrafficLightApp(modifier: Modifier= Modifier) {
    DiceWithButtonAndImage()
}
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)
)
{
    var light by remember { mutableStateOf(1) }
    val textColor=when (light) {
        1 -> colorResource(R.color.green)
        2 -> colorResource(R.color.yellow)
        3 -> colorResource(R.color.red)
        else -> colorResource(R.color.red)
    }
    val lightText=when (light) {
        1 -> stringResource(R.string.green)
        2 -> stringResource(R.string.yellow)
        3 -> stringResource(R.string.red)
        else -> R.string.red
    }
    val imageResource = when (light) {
        1 -> R.drawable.green_light
        2 -> R.drawable.yellow_light
        3 -> R.drawable.red_light
        else -> R.drawable.red_light
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            if (light==3)
            {
                light=1
            }else{
                ++light
            }

        }) {
            Text(stringResource(R.string.app_name))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(imageResource),
            contentDescription = lightText.toString()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(lightText.toString(), fontSize = 36.sp,color=textColor)
    }
}
