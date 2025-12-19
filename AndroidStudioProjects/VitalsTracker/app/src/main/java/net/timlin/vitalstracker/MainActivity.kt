package net.timlin.vitalstracker

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
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
import androidx.compose.runtime.remember

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
import net.timlin.vitalstracker.data.UserPreferences
import net.timlin.vitalstracker.data.VitalsDatabase
import net.timlin.vitalstracker.data.VitalsRepository
import net.timlin.vitalstracker.network.VitalsRow
import net.timlin.vitalstracker.network.fetchVitals
import net.timlin.vitalstracker.ui.theme.VitalsTrackerTheme

import net.timlin.vitalstracker.ui.theme.VitalsViewModel


class MainActivity : ComponentActivity() {

    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            VitalsDatabase::class.java,
            "vitals.db"
        ).build()
    }
    private lateinit var repository: VitalsRepository

    private val viewModel by viewModels<VitalsViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    if (modelClass.isAssignableFrom(VitalsViewModel::class.java)) {
                        @Suppress("UNCHECKED_CAST")
                        return VitalsViewModel(repository, false ) as T
                    }
                    throw IllegalArgumentException("Unknown ViewModel class")
                }
            }
        }
    )
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("ViewModelConstructorInComposable")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repository=  VitalsRepository(db.dao)
        setContent {
            val dataStore = remember {
                UserPreferences(this)
            }
            val username by dataStore.username.collectAsState(initial = "")
            val useLocal by dataStore.isLocal.collectAsState(initial = false)

            //val VitalsList = remember{ mutableStateListOf<VitalsItem>()}
            val viewModel: VitalsViewModel = VitalsViewModel(repository,useLocal)
            viewModel.fetchServerVitals()
            val navController= rememberNavController()


            Text("Welcome $username")
            NavHost(navController = navController, startDestination = "home", builder={
                composable("home"){
                    EnterHomeScreen(navController)
                }
                composable("tracker"){
                    VitalsTrackerTheme {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            EnterVitalsScreen( viewModel)
                        }
                    }
                }
                composable("history"){
                    VitalsTrackerTheme {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            EnterVitalsList(navController, viewModel)
                        }
                    }
                }
                composable("preferences") {
                    Preferences(dataStore)
                }
            })
            BottomNavBar(navController)
        }
    }
    sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
        object Home : BottomNavItem("home", Icons.Default.Home, "Home")
        object Search : BottomNavItem("tracker", Icons.Default.List, "Tracker")
        object Profile : BottomNavItem("history", Icons.Default.ThumbUp, "History")
        object Preferences : BottomNavItem("preferences", Icons.Default.Settings,
            "Preferences")

    }

    @Composable
    fun BottomNavBar(navController: NavController) {

        val items = listOf(BottomNavItem.Home, BottomNavItem.Search, BottomNavItem.Profile,
            BottomNavItem.Preferences)
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




