package net.timlin.vitalstracker



import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import net.timlin.vitalstracker.data.UserPreferences

@Composable
fun Preferences(dataStore: UserPreferences)
{
    val scope = rememberCoroutineScope()

    val username by dataStore.username.collectAsState(initial = "")
    val email by dataStore.email.collectAsState(initial = "")
    val isLocal by dataStore.isLocal.collectAsState(initial=false)

    var usernameText by remember { mutableStateOf(username) }
    var emailText by remember { mutableStateOf(email) }
    var isLocalChecked by remember { mutableStateOf(isLocal) }

    if(usernameText.isEmpty() && emailText.isEmpty()) {
        usernameText = username
        emailText = email
        isLocalChecked=isLocal
    }
    //Text(text = name ?:"missing", fontSize = 32.sp)
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ){
        Spacer(modifier = Modifier.height(12.dp))
        Text(text ="My Preferences:", fontSize = 32.sp)
        OutlinedTextField(
            value = usernameText,
            onValueChange = { usernameText = it },
            label = { Text("Username") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = emailText,
            onValueChange = { emailText = it },
            label = { Text("Email") },
            singleLine = true
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row() {
            Checkbox(
                checked = isLocalChecked,
                onCheckedChange = { isLocalChecked = it }
            )

            Text("\nUse Local Database")
        }
        Spacer(modifier = Modifier.height(12.dp))
        Button (
            onClick = {
                scope.launch {
                    dataStore.setName(usernameText)
                    dataStore.setEmail(emailText)
                    dataStore.setLocal(isLocalChecked)

                }
            }
        ){
            Text("Update")
        }
    }
}