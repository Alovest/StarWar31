package com.example.starwar.di.Modules


import com.example.starwar.Data.Repository.GetPersonDataRepository
import com.example.starwar.Data.Retrofit.Interface.InterfaceStarwarApi
import com.example.starwar.Presentation.ViewModel.GetPersonDataViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.get
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single<InterfaceStarwarApi> {
        Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(InterfaceStarwarApi::class.java)
    }
    factory { GetPersonDataRepository(get()) }
    viewModel { GetPersonDataViewModel(get()) }
}