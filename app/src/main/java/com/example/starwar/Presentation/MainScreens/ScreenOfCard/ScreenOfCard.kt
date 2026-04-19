package com.example.starwar.Presentation.MainScreens.ScreenOfCard

import android.R
import android.app.Person
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.starwar.Data.Retrofit.Pojo.FilmsApi
import com.example.starwar.Data.Retrofit.Pojo.PeopleApi
import com.example.starwar.Presentation.ViewModel.GetPersonDataViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.androidx.viewmodel.factory.KoinViewModelFactory

@Composable
fun ScreenOfCard(person: PeopleApi, navController: NavController, viewModel: GetPersonDataViewModel) {
    val filmsList by viewModel.filmData.observeAsState(emptyList())
    LaunchedEffect(Unit) {
        viewModel.getFilmById(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.padding(vertical = 12.dp, horizontal = 10.dp)) {
            IconButton(
                onClick = {
                navController.popBackStack()
            }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Назад")
            }
            Text(text = person.name, color = Color(0xFF6272A0), style = MaterialTheme.typography.h4)
        }
        Log.d("PersonData", "${person.name}")
        Text(text = "Basic information:",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
            .padding(vertical = 12.dp, horizontal = 10.dp))
        Column {
            Card(
                modifier = Modifier.fillMaxWidth()
                    .heightIn(min = 70.dp),
                shape = RoundedCornerShape(6.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Gray),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
                Text("name: ${person.name}", color = Color.Black)
                Spacer(modifier = Modifier.padding(5.dp))
                Text(text = "height: ${person.height}", color = Color.Black)
            }
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = "Moovies:",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .padding(vertical = 12.dp, horizontal = 10.dp))
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(filmsList) {film ->
                Card(modifier = Modifier.fillMaxWidth()
                    .heightIn(min = 60.dp),
                    shape = RoundedCornerShape(13.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Gray),
                    elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                ) {
                    getFilm(film)
                }
            }
        }
    }
}

@Composable
fun getFilm(filmData: FilmsApi){
    Column(modifier = Modifier.fillMaxSize()
        .padding(vertical = 12.dp, horizontal = 10.dp)
    ) {
        Text(text = filmData.title, color = Color(0xFF6272A0), style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.padding(5.dp))
        Text(text = "Created: ${filmData.created}")
        Spacer(modifier = Modifier.padding(5.dp))
        Text(text = "Director: ${filmData.director}")
    }
    Spacer(modifier = Modifier.padding(25.dp))
}