package edu.ccsf.cs211d.foodpics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.ccsf.cs211d.foodpics.ui.theme.FoodPicsTheme
//enum class FoodType { FRUIT, VEGETABLE }
//enum class FoodColor { ORANGE, GREEN, OTHER }
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodPicsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FoodPicsProcess(
                        name = "Food Pics",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun FoodPicsProcess(name: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        var foodType by remember { mutableStateOf(1) }
        var foodColor by remember { mutableStateOf(3) }
        var foodPrep by remember { mutableStateOf(1) }
        var imageText by remember { mutableStateOf("Food Pics") }

        val imageResource = getImageRes(foodType, foodColor, foodPrep==2)

        Column(
            modifier = Modifier
                .statusBarsPadding()
                .padding(horizontal = 40.dp)
                .verticalScroll(rememberScrollState())
                .safeDrawingPadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = imageText,
                modifier = Modifier.size(150.dp), // Set width and height to 150dp
                contentScale = ContentScale.Crop
            )

            // Food Type: Fruit or Vegetable.
            Spacer(modifier = Modifier.height(36.dp))
            Text("Fruits or Vegetables", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            RadioInput(
                label = stringResource(R.string.food_type_fruit),
                selected = foodType == 1,
                value = 1,
                onSelect = {foodType=it},
            )

            RadioInput(
                label = stringResource(R.string.food_type_vegetable),
                selected = foodType == 2,
                value = 2,
                onSelect = {foodType=(it)},
            )
            // Food Color: Orange, Green, Other.

            Spacer(modifier = Modifier.height(36.dp))
            Text("Color", fontSize = 20.sp, fontWeight = FontWeight.Bold)

            RadioInput(
                label = stringResource(R.string.food_color_orange),
                selected = foodColor == 1,
                value = 1,
                onSelect = {foodColor=(it)},
            )
            RadioInput(
                label = stringResource(R.string.food_color_green),
                selected = foodColor == 2,
                value = 2,
                onSelect = {foodColor=(it)},
            )
            RadioInput(
                label = stringResource(R.string.food_color_other),
                selected = foodColor == 3,
                value = 3,
                onSelect = {foodColor=(it)},
            )

            Spacer(modifier = Modifier.height(36.dp))
            Text("Cooked or raw", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            RadioInput(
                label = stringResource(R.string.food_raw),
                selected = foodPrep == 1,
                value = 1,
                onSelect = {foodPrep=it},
            )

            RadioInput(
                label = stringResource(R.string.food_cooked),
                selected = foodPrep == 2,
                value = 2,
                onSelect = {foodPrep=(it)},
            )
        }
    }
}

@Composable
fun RadioInput(
    label: String,
    value:Int,
    selected: Boolean,
    onSelect:(Int) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .selectable(
                selected = selected,
                onClick = {onSelect(value)}
            )
            .padding(vertical = 8.dp)
    ) {
        RadioButton(
            selected = selected,
            onClick = { onSelect(value) }
        )
        Text(
            label,
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(36.dp))
    }
}
fun getImageRes(type: Int, color: Int, cooked:Boolean): Int {
    return when (type) {
        1 -> when (color) {
            1 -> if (cooked)R.drawable.cooked_orange else R.drawable.orange // Provide these drawables
            2 -> if (cooked)R.drawable.cooked_pear else R.drawable.pear
            3 -> if (cooked)R.drawable.cooked_banana else R.drawable.banana
            else ->if (cooked)R.drawable.cooked_orange else R.drawable.orange
        }
        2 -> when (color) {
            1 -> if (cooked)R.drawable.cooked_carrots else R.drawable.carrots
            2 -> if (cooked)R.drawable.cooked_avocado else R.drawable.avacado
            3 -> if (cooked)R.drawable.cooked_shallot else R.drawable.shallot
            else ->if (cooked)R.drawable.cooked_carrots else R.drawable.carrots
        }
        else ->if (cooked)R.drawable.cooked_carrots else R.drawable.carrots
    }
}

@Preview(showBackground = true)
@Composable
fun FoodPicsPreview() {
    FoodPicsTheme {
        FoodPicsProcess("Hello Food")
    }
}