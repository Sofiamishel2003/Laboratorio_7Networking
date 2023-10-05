package com.example.laboratorio_7_networking.Navigation


sealed class Screens(val route: String) {
    object Home : Screens("home")
    object Category : Screens("category")
    object Detail : Screens("detail")
    object Meals : Screens("meals")
}
