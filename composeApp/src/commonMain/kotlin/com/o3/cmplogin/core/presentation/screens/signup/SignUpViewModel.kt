package com.o3.cmplogin.core.presentation.screens.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.o3.cmplogin.core.domain.usecase.SignUpUseCase
import com.o3.cmplogin.core.presentation.screens.signup.model.SignUpEffect
import com.o3.cmplogin.core.presentation.screens.signup.model.SignUpIntent
import com.o3.cmplogin.core.presentation.screens.signup.model.SignUpState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch


class SignUpViewModel(
    private val signUpUseCase: SignUpUseCase
) {

    var state by mutableStateOf(SignUpState())
        private set
    private val _effect = MutableSharedFlow<SignUpEffect>()
    val effect = _effect.asSharedFlow()

    fun onIntent(intent: SignUpIntent) {
        when (intent) {
            is SignUpIntent.EnterEmail ->
                state = state.copy(email = intent.value)

            is SignUpIntent.EnterPassword ->
                state = state.copy(password = intent.value)

            is SignUpIntent.ConfirmPassword ->
                state = state.copy(confirmPassword = intent.value)

            SignUpIntent.TogglePasswordVisibility ->
                state = state.copy(isPasswordVisible = !state.isPasswordVisible)

            SignUpIntent.ToggleConfirmPasswordVisibility ->
                state = state.copy(isConfirmPasswordVisible = !state.isConfirmPasswordVisible)

            SignUpIntent.Submit -> {
                CoroutineScope(Dispatchers.Main).launch {

                    if (state.email.isBlank() ||
                        state.password.isBlank() ||
                        state.confirmPassword.isBlank()
                    ) {
                        _effect.emit(SignUpEffect.ShowError("All fields required"))
                        return@launch
                    }

                    if (state.password != state.confirmPassword) {
                        _effect.emit(SignUpEffect.ShowError("Passwords do not match"))
                        return@launch
                    }

                    val result = signUpUseCase(state.email, state.password)

                    result
                        .onSuccess {
                            _effect.emit(SignUpEffect.NavigateToDashboard)
                        }
                        .onFailure {
                            _effect.emit(
                                SignUpEffect.ShowError(
                                    it.message ?: "Signup failed"
                                )
                            )
                        }
                }
            }
        }
    }
}