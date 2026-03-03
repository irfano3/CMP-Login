package com.o3.cmplogin.core.presentation.screens.splash.model

sealed class SplashIntent {
    data object OnSplashComplete : SplashIntent()
}