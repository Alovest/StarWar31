package com.example.starwar.presentation.di

import com.example.starwar.presentation.viewModel.GetPersonDataViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel {
        GetPersonDataViewModel(get(),
            get())
    }
}