package com.example.laboratorio_7_networking.uiView.categories.view


import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.laboratorio_7_networking.uiView.categories.repository.CategoriesRepository
import com.example.laboratorio_7_networking.Networking.response.CategoryResponse

class CategoriesViewModel(private val repository: CategoriesRepository = CategoriesRepository()): ViewModel() {
    fun getMealsInCategory(categoryId: String, successCallback: (response: CategoryResponse?) -> Unit) {
        Log.d("CategoriesViewModel", "Invocado con categoryId: $categoryId")
        println("ViewModel getMealsInCategory Invoked with categoryId: $categoryId")

        repository.getMealsInCategory(categoryId) { response ->
            successCallback(response)
        }
    }
}