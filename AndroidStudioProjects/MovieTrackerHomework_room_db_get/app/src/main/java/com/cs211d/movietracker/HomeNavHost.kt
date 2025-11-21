package com.cs211d.movietracker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.cs211d.movietracker.ui.theme.RecommendationsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterHomeScreen( navController: NavController) {
    val viewModel: RecommendationsViewModel  = viewModel()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        //Text(text = "Count:"+count,fontSize = 36.sp)
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = stringResource(R.string.welcome),
            textAlign = TextAlign.Center,
    modifier = Modifier.fillMaxWidth(),
            fontSize = 48.sp)
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                navController.navigate("tracker")
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 24.dp)
        ) {
            Text(text = stringResource(R.string.add_button_text),
                fontSize = 24.sp)
        }
        Button(
            onClick = {
                navController.navigate("recommendation")
                //  MovieScreen()
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 24.dp)
        ) {
            Text(text = stringResource(R.string.movie_recommendation_text),
                fontSize = 24.sp)
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}


