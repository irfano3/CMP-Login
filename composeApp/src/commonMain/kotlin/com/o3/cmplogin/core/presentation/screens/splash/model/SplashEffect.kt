package com.o3.cmplogin.core.presentation.screens.splash.model

sealed class SplashEffect {
    data object NavigateToDashboard : SplashEffect()
    data object NavigateToLogin : SplashEffect()
}