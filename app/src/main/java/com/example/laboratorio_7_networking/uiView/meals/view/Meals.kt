package com.example.laboratorio_7_networking.uiView.meals.view
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.laboratorio_7_networking.Networking.response.MealItem
import com.example.laboratorio_7_networking.uiView.meals.view.MealViewModel

@Composable
fun MealsCategoriesScreen(navController: NavController) {
    val viewModel: MealViewModel = viewModel()
    val rememberedMeals: MutableState<List<MealItem>> = remember { mutableStateOf(emptyList<MealItem>()) }

    viewModel.getMeals { response ->
        val mealsFromTheApi = response?.meals
        rememberedMeals.value = mealsFromTheApi.orEmpty()
    }

    LazyColumn {
        items(rememberedMeals.value) { meal ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate("Category/${meal.name}")
                    },
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = meal.name, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}