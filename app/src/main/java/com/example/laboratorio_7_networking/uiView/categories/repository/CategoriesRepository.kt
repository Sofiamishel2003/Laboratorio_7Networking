package com.example.laboratorio_7_networking.uiView.categories.repository

import com.example.laboratorio_7_networking.Networking.MealsApi
import com.example.laboratorio_7_networking.Networking.MealsWebService
import com.example.laboratorio_7_networking.Networking.response.CategoryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoriesRepository(private val api: MealsApi) {
    suspend fun getCategories() = api.getCategories()
}