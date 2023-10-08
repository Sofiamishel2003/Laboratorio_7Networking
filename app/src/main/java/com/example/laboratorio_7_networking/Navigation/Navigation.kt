package com.example.networking.UIview.Categories.View

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio_7_networking.Navigation.Screens
import com.example.laboratorio_7_networking.Networking.response.CategoryItem
import com.example.laboratorio_7_networking.uiView.categories.view.CategoriesViewModel
import com.example.laboratorio_7_networking.uiView.categories.view.MealsInCategoryScreen
import com.example.laboratorio_7_networking.uiView.mealdetail.view.Mealdetail
import com.example.laboratorio_7_networking.uiView.meals.view.MealsCategoriesScreen


@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = Screens.Home.route,
        modifier = modifier) {
        composable(route = Screens.Home.route) {
            MealsCategoriesScreen(navController)
        }
        composable(route = Screens.Category.route) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId")
            if (categoryId != null) {
                MealsInCategoryScreen(categoryId, navController)
            }
        }
        composable(route = "${Screens.Detail.route}/{mealId}") { backStackEntry ->
            val mealId = backStackEntry.arguments?.getString("mealId")
            if (mealId != null) {
                Mealdetail(mealId, navController)
            }
        }
    }
}


