package com.example.laboratorio_7_networking.uiView.mealdetail.view

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laboratorio_7_networking.uiView.mealdetail.repository.MealDetailRepository
import com.example.laboratorio_7_networking.Networking.response.MealDetailResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MealDetailViewModel( private val repository: MealDetailRepository = MealDetailRepository()) : ViewModel() {

    private val _mealDetail = MutableStateFlow<MealDetailResponse?>(null)
    val mealDetail: StateFlow<MealDetailResponse?> get() = _mealDetail

    fun getMealDetail(mealId: String) {
        viewModelScope.launch {
            val response = repository.getMealDetail(mealId)
            _mealDetail.value = response
        }
    }
}