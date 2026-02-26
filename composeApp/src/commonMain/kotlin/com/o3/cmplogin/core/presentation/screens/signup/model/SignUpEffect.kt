package com.o3.cmplogin.core.presentation.screens.signup.model

sealed class SignUpEffect {
    data object NavigateToDashboard : SignUpEffect()
    data object NavigateToLogin : SignUpEffect()
    data class ShowError(val message: String) : SignUpEffect()
}