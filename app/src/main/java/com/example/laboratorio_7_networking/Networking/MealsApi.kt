// MealsApi.kt
package com.example.laboratorio_7_networking.Networking

import com.example.laboratorio_7_networking.Networking.response.CategoryResponse
import com.example.laboratorio_7_networking.Networking.response.MealDetailResponse
import com.example.laboratorio_7_networking.Networking.response.MealResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsApi{
    @GET("categories.php")
    fun getMeals(): Call<MealResponse>

    @GET("filter.php")
    fun getMealsByCategory(@Query("c") category: String): Call<CategoryResponse>

    @GET("lookup.php")
    suspend fun getMealDetail(@Query("i") mealId: String): MealDetailResponse?
}