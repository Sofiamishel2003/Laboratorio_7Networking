package com.example.laboratorio_7_networking.uiView.categories.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.laboratorio_7_networking.Navigation.Screens
import com.example.laboratorio_7_networking.Networking.response.CategoryItem

@Composable
fun MealsInCategoryScreen(categoryId: String, navController: NavController) {
    val viewModel: CategoriesViewModel = viewModel()
    val rememberedMeals: MutableState<List<CategoryItem>> = remember { mutableStateOf(emptyList<CategoryItem>()) }
    println("MealsInCategoryScreen Invoked with categoryId: $categoryId")

    viewModel.getMealsInCategory(categoryId) { response ->
        println("Response in Screen: $response")

        if (response != null) {
            val mealsFromTheApi = response?.categories
            rememberedMeals.value = mealsFromTheApi.orEmpty()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        IconButton(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier
                .align(Alignment.Start)
        ) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(rememberedMeals.value) { meal ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable {
                            navController.navigate("${Screens.Detail.route}/${meal.idmeal}")
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
}