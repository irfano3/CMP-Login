package com.o3.cmplogin.di

import org.koin.dsl.module
import com.o3.cmplogin.core.data.repository.AuthRepository
import com.o3.cmplogin.project.FakeAuthRepository

actual val platformModule = module {
    single<AuthRepository> { FakeAuthRepository() }
}