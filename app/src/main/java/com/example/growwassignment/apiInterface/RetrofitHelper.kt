package com.example.growwassignment.apiInterface

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
private const val BASE_URL="https://swapi.dev/api/"

        fun getInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
//                .create(Retrofit::class.java)
    }
}