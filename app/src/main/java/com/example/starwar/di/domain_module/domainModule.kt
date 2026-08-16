package com.example.starwar.di.domain_module

import com.example.starwar.data.Repository.GetPersonDataRepositoryImpl
import com.example.starwar.domain.repository.GetPersonDataRepository
import com.example.starwar.domain.usecase.GetFilmUsecase
import com.example.starwar.domain.usecase.GetPersonUsecase
import org.koin.dsl.module

val domainModule = module {
    factory { GetPersonUsecase(get()) }
    factory { GetFilmUsecase(get()) }
    single<GetPersonDataRepository> { GetPersonDataRepositoryImpl(get()) }
}