package com.example.starwar.Presentation.MainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.starwar.Presentation.MainScreens.HomeScreen.ShowPersons
import com.example.starwar.Presentation.MainScreens.NavGraph.NavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavGraph()
        }
    }
}



