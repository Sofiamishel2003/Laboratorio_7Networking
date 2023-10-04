package com.example.laboratorio_7_networking.Networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MealsWebService {

    private var retrofit: Retrofit? = null
    private val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

    fun getRetrofitInstance(): MealsApi {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!.create(MealsApi::class.java)
    }
}
