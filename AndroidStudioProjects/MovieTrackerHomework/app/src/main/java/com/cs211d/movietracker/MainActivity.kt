package com.cs211d.movietracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.cs211d.movietracker.ui.theme.MovieTrackerTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val movieList = remember{ mutableStateListOf<String>()}
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
                            EnterMovieScreen(navController,movieList)
                        }
                    }
                }
                composable("recommendation"){
                    MovieRecommendations(navController,movieList)
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




