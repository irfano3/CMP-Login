package com.o3.cmplogin.project

import android.os.Build
import android.widget.Toast
import com.o3.cmplogin.core.data.repository.AuthRepository
import com.o3.cmplogin.core.data.repository.AuthRepositoryImpl
import com.o3.cmplogin.data.getDatabaseBuilder
import org.koin.dsl.module

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

actual fun showToast(message: String) {
    Toast.makeText(
        MainActivity.instance,
        message,
        Toast.LENGTH_SHORT
    ).show()
}

