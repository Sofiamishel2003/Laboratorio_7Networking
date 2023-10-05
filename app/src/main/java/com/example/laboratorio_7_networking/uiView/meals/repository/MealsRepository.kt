package com.example.laboratorio_7_networking.uiView.meals.repository

import com.example.laboratorio_7_networking.Networking.MealsApi
import com.example.laboratorio_7_networking.Networking.response.MealListResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class MealsRepository(private val api: MealsApi) {

    suspend fun getMeals(category: String): Response<MealListResponse> {
        return withContext(Dispatchers.IO) {
            api.getMealsByCategory(category)
        }
    }
}
