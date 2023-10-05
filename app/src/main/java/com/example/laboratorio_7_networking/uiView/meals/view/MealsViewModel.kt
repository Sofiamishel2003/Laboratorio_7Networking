package com.example.laboratorio_7_networking.uiView.meals.view
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laboratorio_7_networking.Networking.MealsApi
import com.example.laboratorio_7_networking.Networking.response.Meal
import com.example.laboratorio_7_networking.uiView.meals.repository.MealsRepository
import kotlinx.coroutines.launch

class MealsViewModel(private val api: MealsApi): ViewModel() {
    private val repository = MealsRepository(api)
    private val _meals = MutableLiveData<List<Meal>>()
    val meals: LiveData<List<Meal>> get() = _meals

    fun fetchMeals() {
        viewModelScope.launch {
            val response = repository.getMeals("alguna_categoria") // Reemplaza "alguna_categoria" con la categoría que necesitas
            if (response.isSuccessful) {
                _meals.value = response.body()?.meals ?: listOf()
            } else {
                // Manejar el caso de error
            }
        }
    }
}

