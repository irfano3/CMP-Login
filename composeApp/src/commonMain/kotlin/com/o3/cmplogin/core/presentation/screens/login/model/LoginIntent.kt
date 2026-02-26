package com.o3.cmplogin.core.presentation.screens.login.model

sealed class LoginIntent {
    data class EnterEmail(val value: String) : LoginIntent()
    data class EnterPassword(val value: String) : LoginIntent()
    data object TogglePasswordVisibility : LoginIntent()
    data object Submit : LoginIntent()
}