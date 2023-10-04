package com.example.laboratorio_7_networking.Networking.response
import com.google.gson.annotations.SerializedName

data class MealListResponse(
    @SerializedName("meals") val meals: List<MealListItem>
)

data class MealListItem(
    @SerializedName("idMeal") val idMeal: String,
    @SerializedName("strMeal") val strMeal: String,
    @SerializedName("strMealThumb") val strMealThumb: String
)