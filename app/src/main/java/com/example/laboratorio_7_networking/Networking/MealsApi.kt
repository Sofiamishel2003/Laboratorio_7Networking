package com.example.laboratorio_7_networking.Networking

import com.example.laboratorio_7_networking.Networking.response.CategoryResponse
import com.example.laboratorio_7_networking.Networking.response.MealDetailResponse
import com.example.laboratorio_7_networking.Networking.response.MealListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsApi {
    @GET("categories.php")
    suspend fun getCategories(): CategoryResponse

    @GET("filter.php")
    suspend fun getMealsByCategory(@Query("c") category: String): MealListResponse

    @GET("lookup.php")
    suspend fun getMealDetail(@Query("i") id: String): MealDetailResponse
}
