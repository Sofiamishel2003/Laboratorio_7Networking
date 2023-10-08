package com.example.laboratorio_7_networking.uiView.mealdetail.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.laboratorio_7_networking.Networking.MealsApi
import com.example.laboratorio_7_networking.Networking.MealsWebService
import com.example.laboratorio_7_networking.Networking.response.MealDetailResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MealDetailRepository(private val webService: MealsWebService = MealsWebService()) {

    suspend fun getMealDetail(mealId: String): MealDetailResponse? {
        println("Attempting to fetch meal detail with mealId: $mealId")
        println("URL: https://www.themealdb.com/api/json/v1/1/lookup.php?i=$mealId")

        return withContext(Dispatchers.IO) {
            try {
                val response = webService.getMealDetail(mealId)
                println("Response: $response")
                response
            } catch (e: Exception) {
                println("Error: ${e.localizedMessage}")
                null
            }
        }
    }
}