package com.o3.cmplogin.project

import android.app.Application
import com.google.firebase.FirebaseApp
import com.o3.cmplogin.di.koinInit
import org.koin.android.ext.koin.androidContext

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)

        koinInit {
            androidContext(this@MyApplication)
        }
    }
}