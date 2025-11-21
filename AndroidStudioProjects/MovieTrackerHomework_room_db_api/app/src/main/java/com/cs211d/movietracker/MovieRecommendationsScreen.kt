package com.cs211d.movietracker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.cs211d.movietracker.model.MovieAPI
import com.cs211d.movietracker.ui.theme.APIUiState
import com.cs211d.movietracker.ui.theme.MovieViewModel
import com.cs211d.movietracker.ui.theme.RecommendationsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieRecommendations(navController: NavController) {
    var currentMovie by remember {mutableStateOf("")}
    var isError by remember {mutableStateOf(false)}
/*
You have X movies to choose from [This is from the movie tracker list
Button [Make a Recommendation] Randomly pick form the tracker list
Need share button
 */
    //val viewModel: MovieViewModel  = viewModel()
  //  viewModel.setList(movieList)
    val movieViewModel: MovieViewModel =
        viewModel(factory = RecommendationsViewModel.Factory)
    val movieCount:Int = movieViewModel.getCount()

    var title:String = "";
    if (movieCount>0) {
        title=String.format(stringResource(R.string.recommend_choose_from), movieCount)
    }else{
        title=stringResource(R.string.no_recommend_to_choose_from)
    }

    var recommendedMovie:String by remember {mutableStateOf("")}
    var showShareMessage:Boolean by remember {mutableStateOf(false)}
    recommendedMovie=viewModel.recommendedMovie
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text =title,
            fontSize = 36.sp)
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                recommendedMovie=viewModel.getRandomMovie()
                viewModel.getAPIMovie(recommendedMovie)

               // APIUiState.Success -> APIMovie()
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 24.dp)
        ) {
            when(apiUIState)
            {
                is APIUiState.Success -> APIMovie(apiUIState.movies[0])
                is APIUiState.Loading -> {}
                is APIUiState.Error -> {}
            }
            Text(stringResource(R.string.movie_recommendation_text),
                fontSize = 24.sp)
        }
        Spacer(modifier = Modifier.height(24.dp))

        if(recommendedMovie!="") {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {



                val rm = String.format(stringResource( R.string.recommended_movie),recommendedMovie)
                Text(text = rm,
                    fontSize = 36.sp)
                Spacer(modifier = Modifier.height(24.dp))
                Button(onClick = {
                    // Handle click action here
                    showShareMessage = true
                }) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Share"

                    )

                }
                if (showShareMessage) {
                    Share(recommendedMovie)
                }
            }

        }
    }
}
@Composable
fun Share(movie:String)
{
    val text=String.format(stringResource(R.string.i_recommend_movie), movie)
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = text,
            fontSize = 36.sp
        )
    }
}
@Composable
fun APIMovie(movie: MovieAPI)
{
    val text=String.format(stringResource(R.string.i_recommend_movie), movie.title)
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = text,
            fontSize = 36.sp
        )
    }
}