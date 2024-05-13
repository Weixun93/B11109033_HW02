package com.example.b11109033_hw02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.b11109033_hw02.screens.MainScreen
import com.example.b11109033_hw02.screens.DetailScreen
import com.example.b11109033_hw02.ui.theme.B11109033_HW02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            B11109033_HW02Theme(darkTheme = true) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Recording screen switching and monitoring the current Fragment.
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "MainScreen"
                    ) {
                        // Route for the destination by MainScreen.
                        composable(route = "MainScreen") {
                            MainScreen(navController)
                        }
                        // Route for the destination by press index of DetailScreen
                        composable(
                            route = "DetailScreen/{index}",
                            arguments = listOf(
                                navArgument(name = "index") {
                                    type = NavType.IntType
                                }
                            )
                        ) { // Retrieve the index of the pressed card.
                            index->
                            DetailScreen(itemIndex = index.arguments?.getInt("index"))
                        }
                    }
                }
            }
        }
    }
}