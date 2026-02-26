package com.o3.cmplogin.di

import com.o3.cmplogin.core.domain.usecase.CheckAuthUseCase
import com.o3.cmplogin.core.domain.usecase.LoginUseCase
import com.o3.cmplogin.core.domain.usecase.SignUpUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val useCaseModule = module {

    factoryOf(::CheckAuthUseCase)
    factoryOf(::LoginUseCase)
    factoryOf(::SignUpUseCase)

}