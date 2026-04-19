package com.example.starwar.Presentation.MainScreens.NavGraph

import android.util.Log
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.core.app.NotificationCompatExtras
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.starwar.Data.Retrofit.Pojo.PeopleApi
import com.example.starwar.Presentation.MainScreens.HomeScreen.PersonItem
import com.example.starwar.Presentation.MainScreens.HomeScreen.ShowPersons
import com.example.starwar.Presentation.MainScreens.ScreenOfCard.ScreenOfCard
import com.example.starwar.Presentation.ViewModel.GetPersonDataViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavGraph() {

    val navController = rememberNavController()
    val sharedViewModel: GetPersonDataViewModel = koinViewModel()

    NavHost(navController = navController, startDestination = "HomeScreen") {

        composable("HomeScreen") { ShowPersons(navController, sharedViewModel) }

        composable( route = "detail/{personData}",
            arguments = listOf(navArgument("personData"){
                type = NavType.StringType
            })) { backStackEntry ->
            val personDataVal = backStackEntry.arguments?.getString("personData")
            val personsList by sharedViewModel.personData.observeAsState(emptyList())
            Log.d("DetailScreen:", "${personsList.size}")
            if (personsList.isNotEmpty()){
                Log.d("DetailScreen", "Первый элемент: ${personsList.first().name}")
            }
            val person = personsList.find { it.name == personDataVal }
                if (person != null) {
                    ScreenOfCard(person = person, navController, sharedViewModel)
                }
                else {
                    Text(text = "Данные о персонаже не найдены!", color = Color.Red)
                }
        }
    }
}