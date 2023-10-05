package com.example.laboratorio_7_networking.Networking.response
import com.google.gson.annotations.SerializedName


data class MealListResponse(
    @SerializedName("meals") val meals: List<Meal>
)

data class Meal(
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String
)



