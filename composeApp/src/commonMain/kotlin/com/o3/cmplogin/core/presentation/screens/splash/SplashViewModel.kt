package com.o3.cmplogin.core.presentation.screens.splash

import com.o3.cmplogin.core.domain.usecase.CheckAuthUseCase
import com.o3.cmplogin.core.presentation.screens.splash.model.SplashEffect
import com.o3.cmplogin.core.presentation.screens.splash.model.SplashIntent
import com.o3.cmplogin.project.getPlatform
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class SplashViewModel(
    private val checkAuthUseCase: CheckAuthUseCase
) {

    private val _effect = MutableSharedFlow<SplashEffect>()
    val effect = _effect.asSharedFlow()

    fun onIntent(intent: SplashIntent) {
        when (intent) {
            SplashIntent.Start -> {
                CoroutineScope(Dispatchers.Main).launch {

                    delay(1500)

                    if (checkAuthUseCase()) {
                        _effect.emit(SplashEffect.NavigateToDashboard)
                    } else {
                        _effect.emit(SplashEffect.NavigateToLogin)
                    }
                }
            }
        }
    }

    fun getPlatformName(): String {
        return getPlatform().name
    }
}
