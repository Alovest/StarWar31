package com.example.starwar.Presentation.MainScreens.HomeScreen

import android.net.Uri
import android.net.Uri.encode
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.starwar.Data.Retrofit.Pojo.PeopleApi
import com.example.starwar.Presentation.ViewModel.GetPersonDataViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ShowPersons(navController: NavController, viewModel: GetPersonDataViewModel) {
    val personsList by viewModel.personData.observeAsState(emptyList())
    var searchQuery by remember{ mutableStateOf("") }
    val keyBoardController = LocalSoftwareKeyboardController.current
    val filteredItems = personsList.filter { it.name.contains(searchQuery, ignoreCase = true) }
    LaunchedEffect(Unit) {
        viewModel.getPersonViewModel(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18))
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Star War Characters",modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 13.dp),
            style = MaterialTheme.typography.h5,
            color = Color(0xFF6272A0))
            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Поиск") },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        keyBoardController?.hide()
                    }
                ),
                modifier = Modifier.fillMaxWidth()
            )
        Spacer(modifier = Modifier.padding(16.dp))
        LazyColumn {
            items(filteredItems) { person ->
                PersonItem(person, navController)
            }
        }
    }
}

@Composable
fun PersonItem(person: PeopleApi, navController: NavController) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(80.dp)
        .padding(start = 10.dp, end = 10.dp)
        .clickable {
            Log.d("PersonData", "${person.name}")
            navController.navigate("detail/${person.name}")
        },
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.Gray,
        elevation = 6.dp
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 7.dp, vertical = 8.dp)) {
            Text(
                text = person.name,
                modifier = Modifier.padding(4.dp),
                style = MaterialTheme.typography.h6,
                color = Color(0xFF6272A0)
            )
            Spacer(modifier = Modifier.padding(2.dp))

            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 7.dp, vertical = 5.dp)) {
                Text(text = "Height: ${person.height}")
                Spacer(modifier = Modifier.padding(8.dp))
                Text(text = "Mass: ${person.mass}")
                Spacer(modifier = Modifier.padding(8.dp))
                Text(text = "Hair: ${person.hair_color}")
                Spacer(modifier = Modifier.padding(8.dp))
                Text(text = "Eyes: ${person.eye_color}")
            }
        }
    }
    Spacer(modifier = Modifier.padding(8.dp))
}
