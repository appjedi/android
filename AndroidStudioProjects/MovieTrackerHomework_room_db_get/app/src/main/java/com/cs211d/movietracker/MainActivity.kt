package com.cs211d.movietracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.cs211d.movietracker.data.MovieDatabase
import com.cs211d.movietracker.ui.theme.MovieTrackerTheme
import com.cs211d.movietracker.ui.theme.MovieViewModel

class MainActivity : ComponentActivity() {
    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            MovieDatabase::class.java,
            "movies.db"
        ).build()
    }
    private val viewModel by viewModels<MovieViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
                        @Suppress("UNCHECKED_CAST")
                        return MovieViewModel(db.dao) as T
                    }
                    throw IllegalArgumentException("Unknown ViewModel class")
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent {
            val navController= rememberNavController()
            NavHost(navController = navController, startDestination = "home", builder={
                composable("home"){
                    EnterHomeScreen(navController)
                }
                composable("tracker"){
                    MovieTrackerTheme {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            val state by viewModel.state.collectAsState()
                            EnterMovieScreen(state=state, onEvent = viewModel::onEvent)
                        }
                    }
                }
                composable("recommendation"){
                    val state by viewModel.state.collectAsState()
                    MovieRecommendations(state=state, viewModel)
                }
            })
            BottomNavBar(navController)

        }
    }
    sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
        object Home : BottomNavItem("home", Icons.Default.Home, "Home")
        object Search : BottomNavItem("tracker", Icons.Default.List, "Tracker")
        object Profile : BottomNavItem("recommendation", Icons.Default.ThumbUp, "Recommendation")
    }

    @Composable
    fun BottomNavBar(navController: NavController) {
        val items = listOf(BottomNavItem.Home, BottomNavItem.Search, BottomNavItem.Profile)
        Box (modifier = Modifier.fillMaxSize()){
            Column(modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally){

                NavigationBar {
                    val currentRoute =
                        navController.currentBackStackEntryAsState().value?.destination?.route
                    items.forEach { item ->
                        NavigationBarItem(
                            icon = { Icon(item.icon, contentDescription = item.label) },
                            label = { Text(item.label) },
                            selected = currentRoute == item.route,
                            onClick = {
                                navController.navigate(item.route)
                            }
                        )
                    }
                }
            }
        }
    }
}




