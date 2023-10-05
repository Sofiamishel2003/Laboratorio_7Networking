package com.example.laboratorio_7_networking.Networking.response
import com.google.gson.annotations.SerializedName


data class MealDetailResponse(
    @SerializedName("meals") val meals: List<MealDetail>
)

data class MealDetail(
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String
)