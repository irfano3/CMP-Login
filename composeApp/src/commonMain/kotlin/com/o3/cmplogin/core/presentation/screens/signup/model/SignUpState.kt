package com.o3.cmplogin.core.presentation.screens.signup.model

data class SignUpState(
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isPasswordVisible: Boolean = false,
    val isConfirmPasswordVisible: Boolean = false
)