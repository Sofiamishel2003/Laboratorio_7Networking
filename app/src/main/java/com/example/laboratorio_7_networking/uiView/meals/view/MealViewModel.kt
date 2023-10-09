package com.example.laboratorio_7_networking.uiView.meals.view
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laboratorio_7_networking.Networking.response.MealDetailResponse
import com.example.laboratorio_7_networking.Networking.response.MealResponse
import com.example.laboratorio_7_networking.uiView.mealdetail.repository.MealDetailRepository
import com.example.laboratorio_7_networking.uiView.meals.repository.MealsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MealViewModel (private val repository: MealsRepository = MealsRepository()): ViewModel() {
    fun getMeals(successCallback: (response: MealResponse?) -> Unit) {
        Log.d("MealViewModel", "Invocado con Meals: ${getMeals(successCallback)}")
        repository.getMeals { response ->
            successCallback(response)
        }
    }
}