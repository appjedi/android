package com.cs211d.movietracker

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
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
import androidx.navigation.NavController
import com.cs211d.movietracker.network.APIMovie
import com.cs211d.movietracker.network.Movie
import com.cs211d.movietracker.network.fetchMovie
import com.cs211d.movietracker.ui.theme.MovieViewModel
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieRecommendations(state: MovieState,
     viewModel: MovieViewModel) {
    val movieCount:Int = state.movies.count()

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
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            Text(stringResource(R.string.movie_recommendation_text),
                fontSize = 24.sp)
        }
        Spacer(modifier = Modifier.height(24.dp))

        if(recommendedMovie!="") {


            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                val rm = String.format(stringResource( R.string.recommended_movie),recommendedMovie)
                Spacer(modifier = Modifier.height(24.dp))

                Text(text = rm,
                    fontSize = 24.sp)
                Spacer(modifier = Modifier.height(24.dp))
                MovieDetails(recommendedMovie)
                Spacer(modifier = Modifier.height(24.dp))

                Button(onClick = {
                    // Handle click action here
                    showShareMessage = true
                }) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.Share, contentDescription = null)
                        Spacer(modifier = Modifier.width(18.dp))
                        Text("Home")
                    }
                }
                if (showShareMessage) {
                    Share(recommendedMovie)
                }
            }

        }
    }
}

@Composable
fun MovieDetails(search: String)
{
    val md: Movie?=APIMovie(search)
    val title=String.format(stringResource(R.string.movie_detail_title), md?.Title)
    val year=String.format(stringResource(R.string.movie_detail_year), md?.Year)
    val actors=String.format(stringResource(R.string.movie_detail_actors), md?.Actors)
    val plot=String.format(stringResource(R.string.movie_detail_plot), md?.Plot)
    Column(
        modifier = Modifier.fillMaxWidth(),
        //horizontalAlignment = Alignment.Horizontal
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = title,
            fontSize = 36.sp
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = year,
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = actors,
            fontSize = 24.sp
        )
/*
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = plot,
            fontSize = 24.sp
        )
*/

    }
}
@Composable
fun Share(movie:String)
{
    val text=String.format(stringResource(R.string.i_recommend_movie), movie)
    Spacer(modifier = Modifier.height(24.dp))

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