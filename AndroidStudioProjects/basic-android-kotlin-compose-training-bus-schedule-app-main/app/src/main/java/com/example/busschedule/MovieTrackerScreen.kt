package com.example.busschedule

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.busschedule.ui.MovieViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterMovieScreen( ) {
    var currentMovie by remember {mutableStateOf("")}
    var isError by remember {mutableStateOf(false)}

    val viewModel: MovieViewModel = viewModel()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = currentMovie,
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
                isError=viewModel.createMovie(it)
                currentMovie=viewModel.currentMovie
            },
            label = { Text(stringResource(R.string.movie_field_label)) },
            isError =   isError,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            )
        )

        Button(
            onClick = {
                isError=!viewModel.updateEntree((currentMovie))
                if (!isError) {
                    currentMovie = ""
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


        LazyColumn {
            items(viewModel.getList()) { movie ->
                MovieCard(
                    movie = movie
                )
            }
        }
    }
}

@Composable
fun MovieCard(movie: String) {
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
            Text(text = movie, fontSize = 24.sp)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}