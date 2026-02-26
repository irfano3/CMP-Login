package com.o3.cmplogin.core.navigation

import kotlinx.serialization.Serializable

sealed class Routes {
    @Serializable
    data object SplashScreen : Routes()
    @Serializable
    data object SignUpScreen : Routes()
    @Serializable
    data object LoginScreen : Routes()
    @Serializable
    data object DashboardScreen : Routes()
}
