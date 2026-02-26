package com.o3.cmplogin.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
expect fun showToast(message: String)