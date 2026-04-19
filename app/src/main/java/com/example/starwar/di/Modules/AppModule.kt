package com.example.starwar.di.Modules


import com.example.starwar.Data.Repository.GetPersonDataRepositoryImpl
import com.example.starwar.domain.repository.GetPersonDataRepository
import com.example.starwar.Data.Retrofit.Interface.InterfaceStarwarApi
import com.example.starwar.Presentation.ViewModel.GetPersonDataViewModel
import com.example.starwar.domain.usecase.GetFilmUsecase
import com.example.starwar.domain.usecase.GetPersonUsecase
import org.koin.androidx.viewmodel.dsl.viewModel
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
    factory { GetPersonUsecase(get()) }
    factory { GetFilmUsecase(get()) }
    single<GetPersonDataRepository> { GetPersonDataRepositoryImpl(get()) }
    viewModel { GetPersonDataViewModel(get(), get()) }
}