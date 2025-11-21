package com.cs211d.movietracker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cs211d.movietracker.network.APIMovie
import com.cs211d.movietracker.network.Movie
import com.cs211d.movietracker.ui.theme.MovieViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterMovieScreen(
    state: MovieState,
    onEvent:(MovieEvent) -> Unit
) {
    var currentMovie by remember {mutableStateOf("")}
    var message by remember {mutableStateOf("")}
    var isError by remember {mutableStateOf(false)}
    var colorId by remember { mutableStateOf( R.color.black) }
    var colorMessage  =colorResource(id = colorId)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(message,fontSize = 36.sp, color=colorMessage)
        Spacer(modifier = Modifier.height(24.dp))

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
                currentMovie=it
                onEvent(MovieEvent.SetMovieName(it))
            },
            label = { Text(stringResource(R.string.movie_field_label)) },
            isError =   isError,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            )
        )

        Button(
            onClick = {
                val m: Movie?= APIMovie(currentMovie)
                if (m==null)
                {
                    colorId = R.color.red
                    message="Invalid"
                }else {
                    colorId = R.color.green
                    currentMovie=m.Title
                    message="Saved"

                    onEvent(MovieEvent.SaveMovie)
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
            items(state.movies) { movie ->
                MovieCard(
                    movie = movie, onEvent
                )
            }
        }
    }
}

@Composable
fun MovieCard(movie: com.cs211d.movietracker.data.Movie,onEvent:(MovieEvent) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
    ) {

        Row(
            modifier = Modifier
                .padding(24.dp)
        ) {
            IconButton(onClick = {  onEvent(MovieEvent.DeleteMovie(movie)) }) {
                Icon(Icons.Default.Delete, contentDescription = null)
            }
            Text(movie.movieName,fontSize = 24.sp)

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}