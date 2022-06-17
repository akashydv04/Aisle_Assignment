package com.example.aisleassignment.application

import android.app.Application
import com.example.aisleassignment.module.adapterModule
import com.example.aisleassignment.module.networkModule
import com.example.aisleassignment.module.repositoryModule
import com.example.aisleassignment.module.viewModelModule
import com.example.aisleassignment.prefs.PreferenceHelper
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(androidContext = this@MyApplication)

            modules(listOf(networkModule, viewModelModule, adapterModule,repositoryModule))
        }

        PreferenceHelper.init(this)
    }
}