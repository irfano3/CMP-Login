package com.o3.cmplogin.di

import com.o3.cmplogin.core.data.repository.AuthRepositoryImpl
import com.o3.cmplogin.core.data.repository.AuthRepository
import com.o3.cmplogin.core.domain.usecase.CheckAuthUseCase
import com.o3.cmplogin.core.domain.usecase.LoginUseCase
import com.o3.cmplogin.core.domain.usecase.SignUpUseCase
import com.o3.cmplogin.core.presentation.screens.login.LoginScreen
import com.o3.cmplogin.core.presentation.screens.login.LoginViewModel
import com.o3.cmplogin.core.presentation.screens.signup.SignUpViewModel
import com.o3.cmplogin.core.presentation.screens.splash.SplashViewModel
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.auth
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

expect val platformModule: Module
val appModule = module {

    single<FirebaseAuth> { Firebase.auth }

    single<AuthRepository> { AuthRepositoryImpl(get()) }

    singleOf(::SplashViewModel)
    singleOf(::LoginViewModel)
    singleOf(::SignUpViewModel)
}