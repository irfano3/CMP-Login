package com.o3.cmplogin.core.presentation.screens.dashboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.o3.cmplogin.core.data.repository.AuthRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DashboardViewModel(
    private val authRepository: AuthRepository
) {

    var email by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    init {
        CoroutineScope(Dispatchers.Main).launch {
            val user = authRepository.getLastUser()
            email = user?.email ?: ""
            password = user?.password ?: ""
        }
    }
}