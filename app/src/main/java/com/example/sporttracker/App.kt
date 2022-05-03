package com.example.sporttracker

import android.app.Application
import com.example.sporttracker.di.AppComponent
import com.example.sporttracker.di.DaggerAppComponent
import com.example.sporttracker.di.module.ContextModule

class App : Application() {

    companion object {

        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent
            .builder()
            .contextModule(ContextModule(this.applicationContext))
            .build()
    }
}