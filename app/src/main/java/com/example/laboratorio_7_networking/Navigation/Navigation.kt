package com.example.laboratorio_7_networking.Navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio_7_networking.uiView.categories.view.MealsInCategoryScreen
import com.example.laboratorio_7_networking.uiView.mealdetail.view.MealDetailScreen
import com.example.laboratorio_7_networking.uiView.meals.view.MealScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            MealScreen(navController)
        }
        composable("category/{categoryId}") { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId")
            if (categoryId != null) {
                MealsInCategoryScreen(categoryId, navController)
            }
        }
        composable("detail/{mealId}") { backStackEntry ->
            val mealId = backStackEntry.arguments?.getString("mealId")
            if (mealId != null) {
                MealDetailScreen(mealId, navController)
            }
        }
    }
}
