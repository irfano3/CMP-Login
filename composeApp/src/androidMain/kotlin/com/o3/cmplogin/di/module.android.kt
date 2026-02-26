package com.o3.cmplogin.di

import com.o3.cmplogin.core.data.repository.AuthRepository
import com.o3.cmplogin.core.data.repository.AuthRepositoryImpl
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.auth
import org.koin.dsl.module

actual val platformModule = module {
    single<AuthRepository> { AuthRepositoryImpl() }
}