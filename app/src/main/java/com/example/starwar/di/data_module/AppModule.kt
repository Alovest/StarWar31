package com.example.starwar.di.data_module


import com.example.starwar.data.Retrofit.Interface.InterfaceStarwarApi
import com.example.starwar.presentation.viewModel.GetPersonDataViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single<InterfaceStarwarApi> {
        Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(InterfaceStarwarApi::class.java)
    }

}