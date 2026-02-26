package com.o3.cmplogin.project

import android.os.Build
import android.widget.Toast

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