package com.example.laboratorio_7_networking.Networking

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MealsWebService {
    private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/" // Reemplaza con tu URL base

    private val logging = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()

    val api: MealsApi = retrofit.create(MealsApi::class.java)
}
