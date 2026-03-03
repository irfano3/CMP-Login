package com.o3.cmplogin.core.presentation.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.o3.cmplogin.core.data.repository.AuthRepository
import com.o3.cmplogin.core.presentation.screens.login.model.LoginEffect
import com.o3.cmplogin.core.presentation.screens.login.model.LoginIntent
import com.o3.cmplogin.core.presentation.screens.login.model.LoginState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val authRepository: AuthRepository
) {

    var state by mutableStateOf(LoginState())
        private set

    private val _effect = MutableSharedFlow<LoginEffect>()

    val effect = _effect.asSharedFlow()

    fun onIntent(intent: LoginIntent) {
        when (intent) {

            is LoginIntent.EnterEmail ->
                state = state.copy(email = intent.value)

            is LoginIntent.EnterPassword ->
                state = state.copy(password = intent.value)

            LoginIntent.TogglePasswordVisibility ->
                state = state.copy(isPasswordVisible = !state.isPasswordVisible)

            LoginIntent.Submit -> {
                CoroutineScope(Dispatchers.Main).launch {

                    if (state.email.isBlank() || state.password.isBlank()) {
                        _effect.emit(LoginEffect.ShowError("Please enter email & password"))
                        return@launch
                    }

                    val result = authRepository.login(state.email, state.password)

                    result
                        .onSuccess {
                            _effect.emit(LoginEffect.NavigateToDashboard)
                        }
                        .onFailure {
                            _effect.emit(
                                LoginEffect.ShowError("Invalid email or password")
                            )
                        }
                }
            }
        }
    }
}