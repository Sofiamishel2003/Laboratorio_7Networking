package com.example.laboratorio_7_networking.uiView.meals.view
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.laboratorio_7_networking.Networking.response.Meal

@Composable
fun MealScreen(viewModel: MealsViewModel) {
    val mealsState = remember { mutableStateOf(listOf<Meal>()) }
    LazyColumn {
        items(mealsState.value) { meal ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = meal.strMeal,  // Asegúrate de que 'strMeal' es un campo en tu objeto 'Meal'
                    style = TextStyle(fontSize = 20.sp)
                )
            }
        }
    }
}

