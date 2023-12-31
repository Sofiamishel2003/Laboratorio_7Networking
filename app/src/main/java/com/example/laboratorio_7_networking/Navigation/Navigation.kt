package com.example.networking.UIview.Categories.View
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio_7_networking.Navigation.Screens
import com.example.laboratorio_7_networking.uiView.categories.view.MealsInCategoryScreen
import com.example.laboratorio_7_networking.uiView.mealdetail.view.MealDetail
import com.example.laboratorio_7_networking.uiView.meals.view.MealsListScreen


@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = Screens.Home.route,
        modifier = modifier) {
        composable(route = Screens.Home.route) {
            MealsListScreen(navController)
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
                MealDetail(mealId, navController)
            }
        }
    }
}


