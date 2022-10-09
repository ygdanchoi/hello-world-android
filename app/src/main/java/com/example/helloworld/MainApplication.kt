package com.example.helloworld

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(getModules())
        }
    }

    private fun getModules() = module {
        single<Converter.Factory> { GsonConverterFactory.create() }
        single<MainService> {
            Retrofit.Builder().baseUrl("http://10.0.2.2:3000")
                .addConverterFactory(get())
                .build()
                .create(MainService::class.java)
        }
        single { MainRepository(get()) }
        viewModel { MainViewModel(get()) }
    }
}