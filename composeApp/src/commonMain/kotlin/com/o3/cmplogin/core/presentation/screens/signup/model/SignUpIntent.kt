package com.o3.cmplogin.core.presentation.screens.signup.model

sealed class SignUpIntent {
    data class EnterEmail(val value: String) : SignUpIntent()
    data class EnterPassword(val value: String) : SignUpIntent()
    data class ConfirmPassword(val value: String) : SignUpIntent()
    data object TogglePasswordVisibility : SignUpIntent()
    data object ToggleConfirmPasswordVisibility : SignUpIntent()
    data object Submit : SignUpIntent()
}
