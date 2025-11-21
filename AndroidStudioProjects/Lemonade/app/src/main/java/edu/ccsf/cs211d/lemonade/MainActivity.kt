package edu.ccsf.cs211d.lemonade



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.ccsf.cs211d.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}
@Composable
fun LemonApp(modifier: Modifier = Modifier) {
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        var phase by remember { mutableStateOf(1) }
        val imageText=when (phase) {
            1 -> stringResource(R.string.phase1)
            2 -> stringResource(R.string.phase2)
            3 -> stringResource(R.string.phase3)
            4 -> stringResource(R.string.phase4)
            else -> R.string.phase1
        }
        val imageResource = when (phase) {
            1 -> R.drawable.lemon_tree
            2 -> R.drawable.lemon_squeeze
            3 -> R.drawable.lemon_drink
            4 -> R.drawable.lemon_restart
            else -> R.drawable.lemon_restart
        }
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(48.dp))
            Button(onClick = {
                if (phase==4)
                {
                    phase=1
                }else{
                    ++phase
                }

            }) {
                Image(

                    painter = painterResource(imageResource),
                    contentDescription = imageText.toString()
                )
            }
            Spacer(modifier = Modifier.height(36.dp))
            Text(imageText.toString(), fontSize = 16.sp)
        }
        //Text(text = "Hello there!")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}