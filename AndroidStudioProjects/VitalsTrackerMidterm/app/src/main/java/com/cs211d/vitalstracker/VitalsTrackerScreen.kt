package com.cs211d.vitalstracker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.cs211d.vitalstracker.model.VitalsItem
import com.cs211d.vitalstracker.ui.theme.VitalsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterVitalsScreen(navController: NavController, viewModel: VitalsViewModel) {

    var isError by remember {mutableStateOf(false)}
    // dateTaken, weight,pulse,bpDiastolic,bpSystolic,bloodSugar
    var dateTaken:String by  remember {mutableStateOf("20251028")}
    var weight:Float by  remember { mutableFloatStateOf(190f) }
    var pulse:Int by  remember { mutableIntStateOf(60) }
    var bpDiastolic:Int by  remember { mutableIntStateOf(130) }
    var bpSystolic:Int by  remember { mutableIntStateOf(70) }
    var bloodSugar:Float by  remember { mutableFloatStateOf(90f) }
   // val viewModel: VitalsViewModel  = viewModel()

    //viewModel.setList(vitalsList)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = dateTaken,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                disabledContainerColor = MaterialTheme.colorScheme.surface,
            ),
            onValueChange = {
                dateTaken=it

            },
            label = { Text(stringResource(R.string.date_field_label)) },
            isError =   isError,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            )
        )
        OutlinedTextField(
            value = weight.toString(),
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                disabledContainerColor = MaterialTheme.colorScheme.surface,
            ),
            onValueChange = {
                weight=parse(it,0.0f)
            },
            label = { Text(stringResource(R.string.weight_field_label)) },
            isError =   isError,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            )
        )
        OutlinedTextField(
            value = bpSystolic.toString(),
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                disabledContainerColor = MaterialTheme.colorScheme.surface,
            ),
            onValueChange = {
                bpSystolic=parse(it,0)

            },
            label = { Text(stringResource(R.string.bp_systolic_field_label)) },
            isError =   isError,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            )
        )
        OutlinedTextField(
            value = bpDiastolic.toString(),
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                disabledContainerColor = MaterialTheme.colorScheme.surface,
            ),
            onValueChange = {
                bpDiastolic=parse(it,0)

            },
            label = { Text(stringResource(R.string.bp_diastolic_field_label)) },
            isError =   isError,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            )
        )
        OutlinedTextField(
            value = pulse.toString(),
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                disabledContainerColor = MaterialTheme.colorScheme.surface,
            ),
            onValueChange = {
                pulse=parse(it,0)

            },
            label = { Text(stringResource(R.string.pulse_field_label)) },
            isError =   isError,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            )
        )
        OutlinedTextField(
            value = bloodSugar.toString(),
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                disabledContainerColor = MaterialTheme.colorScheme.surface,
            ),
            onValueChange = {
                bloodSugar=parse(it,0.0f)

            },
            label = { Text(stringResource(R.string.blood_sugar_field_label)) },
            isError =   isError,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            )
        )
        Button(
            onClick = {
                val item: VitalsItem= VitalsItem()
                item.dateTaken=dateTaken
                item.bloodSugar=bloodSugar
                item.pulse=pulse
                item.weight=weight
                item.bpDiastolic=bpDiastolic
                item.bpSystolic
                isError=!viewModel.addVitals(item)
                if (!isError) {
                   // currentVitals = null
                } else {
                    isError = true
                }
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 24.dp)
        ) {
            Text(text = stringResource(R.string.add_button_text),
                fontSize = 24.sp)
        }
        Spacer(modifier = Modifier.height(24.dp))



    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterVitalsList(navController: NavController, viewModel: VitalsViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

       // val viewModel: VitalsViewModel  = viewModel()
        Spacer(modifier = Modifier.height(24.dp))


        LazyColumn {
            items(viewModel.getList()) { item ->
                VitalsCard(
                    item = item
                )
            }
        }
    }
}
@Composable
fun VitalsCard(item: VitalsItem)
{
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = item.toString(), fontSize = 24.sp)
            Spacer(modifier = Modifier.height(8.dp))
        }

    }
}
//@Composable
fun parse(value:String, alt:Int):Int
{
    try {
        return value.toInt()
    }catch (ex: Exception)
    {
        return alt;
    }
}
fun parse(value:String, alt:Float):Float
{
    try {
        return value.toFloat()
    }catch (ex: Exception)
    {
        return alt;
    }
}