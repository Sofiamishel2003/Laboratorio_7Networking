package com.example.laboratorio_7_networking.uiView.categories.view


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laboratorio_7_networking.Networking.response.Category
import com.example.laboratorio_7_networking.uiView.categories.repository.CategoriesRepository
import com.example.laboratorio_7_networking.Networking.response.CategoryResponse
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf

class CategoriesViewModel(
    private val repository: CategoriesRepository
) : ViewModel() {
    val categories = mutableStateOf<List<Category>>(listOf())

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            val response = repository.getCategories()
            categories.value = response.categories
        }
    }
}
