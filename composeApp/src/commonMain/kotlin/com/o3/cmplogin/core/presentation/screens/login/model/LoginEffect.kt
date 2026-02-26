package com.o3.cmplogin.core.presentation.screens.login.model

sealed class LoginEffect {
    data object NavigateToDashboard : LoginEffect()
    data class ShowError(val message: String) : LoginEffect()
}