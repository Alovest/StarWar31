package com.example.starwar.data.Retrofit.RetrofitInstance

import com.example.starwar.data.Retrofit.Interface.InterfaceStarwarApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: InterfaceStarwarApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(InterfaceStarwarApi::class.java)
    }
}