package com.example.yassirtest.util

import android.app.Application
import com.example.yassirtest.util.DependencyInjection
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        DependencyInjection.startKoinInjection()
    }

}