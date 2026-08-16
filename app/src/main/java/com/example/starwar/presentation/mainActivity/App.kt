package com.example.starwar.presentation.mainActivity

import android.app.Application
import com.example.starwar.di.data_module.dataModule
import com.example.starwar.di.domain_module.domainModule
import com.example.starwar.presentation.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidContext(this@App)
            modules(dataModule, domainModule, uiModule)
        }
    }
}