package com.example.laboratorio_7_networking.Networking.response
import com.google.gson.annotations.SerializedName

data class MealDetailResponse(
    @SerializedName("meals") val meals: List<MealDetail>
)

data class MealDetail(
    @SerializedName("idMeal") val idMeal: String,
    @SerializedName("strMeal") val strMeal: String,
    @SerializedName("strDrinkAlternate") val strDrinkAlternate: String?,
    @SerializedName("strCategory") val strCategory: String,
    @SerializedName("strArea") val strArea: String,
    @SerializedName("strInstructions") val strInstructions: String,
    @SerializedName("strMealThumb") val strMealThumb: String,
    @SerializedName("strTags") val strTags: String?,
    @SerializedName("strYoutube") val strYoutube: String?,
    @SerializedName("strIngredient1") val strIngredient1: String?,
    // ... hasta strIngredient20
    @SerializedName("strMeasure1") val strMeasure1: String?,
    // ... hasta strMeasure20
    @SerializedName("strSource") val strSource: String?,
    @SerializedName("strImageSource") val strImageSource: String?,
    @SerializedName("strCreativeCommonsConfirmed") val strCreativeCommonsConfirmed: String?,
    @SerializedName("dateModified") val dateModified: String?
)
