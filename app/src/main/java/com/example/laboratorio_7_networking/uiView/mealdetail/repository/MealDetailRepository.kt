package com.example.laboratorio_7_networking.uiView.mealdetail.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.laboratorio_7_networking.Networking.MealsApi
import com.example.laboratorio_7_networking.Networking.response.MealDetail
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MealDetailRepository(private val api: MealsApi) {

    fun getMealDetail(id: String): LiveData<MealDetail> {
        val liveData = MutableLiveData<MealDetail>()

        GlobalScope.launch {
            try {
                val response = api.getMealDetail(id)
                if (response.meals.isNotEmpty()) {
                    liveData.postValue(response.meals[0])
                }
            } catch (e: Exception) {
                // Handle error
            }
        }

        return liveData
    }
}
