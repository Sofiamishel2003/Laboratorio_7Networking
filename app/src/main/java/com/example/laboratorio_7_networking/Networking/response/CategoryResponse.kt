package com.example.laboratorio_7_networking.Networking.response

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("categories") val categories: List<Category>
)

data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
)