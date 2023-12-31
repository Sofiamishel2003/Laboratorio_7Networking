package com.example.laboratorio_7_networking.Navigation


sealed class Screens(val route: String){
    object Home: Screens("Home")
    object Category: Screens("Category/{categoryId}")
    object Detail: Screens("MealDetail/{mealId}")
}
