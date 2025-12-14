package com.cs211d.movietracker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.cs211d.movietracker.data.UserPreferences
import kotlinx.coroutines.launch

@Composable
fun Preferences(dataStore: UserPreferences)
{
    val name by dataStore.name.collectAsStateWithLifecycle("")
    val coroutineScope = rememberCoroutineScope  ()
    var text by remember { mutableStateOf(name?:"") }
    //Text(text = name ?:"missing", fontSize = 32.sp)
    Column {
        Spacer(modifier = Modifier.height(12.dp))
        Text(text ="My Preferences:", fontSize = 32.sp)
        OutlinedTextField(
            value = name ?:"",
            onValueChange = { text = it },
            label = { Text("Username") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button (
            onClick = {
                coroutineScope.launch {
                    dataStore.setName(text)
                }
            }
        ){
            Text("Update")
        }
    }
}