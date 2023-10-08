package com.example.laboratorio_7_networking.Networking.response
import com.google.gson.annotations.SerializedName

data class MealDetailResponse(@SerializedName("meals") val details: List<DetailItem>?)

data class DetailItem(
    @SerializedName("idMeal") val idMeal: String,
    @SerializedName("strMeal") val strMeal: String,
    @SerializedName("strInstructions") val strInstructions: String
)