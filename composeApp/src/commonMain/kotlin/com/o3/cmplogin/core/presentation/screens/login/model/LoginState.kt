package com.o3.cmplogin.core.presentation.screens.login.model

data class LoginState(
    val email: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false
)