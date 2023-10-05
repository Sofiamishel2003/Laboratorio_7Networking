package com.example.laboratorio_7_networking.uiView.mealdetail.view

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laboratorio_7_networking.Networking.response.MealDetail
import com.example.laboratorio_7_networking.uiView.mealdetail.repository.MealDetailRepository
import com.example.laboratorio_7_networking.Networking.response.MealDetailResponse
import kotlinx.coroutines.launch

class MealDetailViewModel(
    private val repository: MealDetailRepository
) : ViewModel() {
    val mealDetail = mutableStateOf<MealDetail?>(null)

    fun fetchMealDetail(mealId: String) {
        viewModelScope.launch {
            mealDetail.value = repository.getMealDetail(mealId).value
        }
    }
}