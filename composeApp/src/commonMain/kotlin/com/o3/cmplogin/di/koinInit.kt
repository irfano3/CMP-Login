package com.o3.cmplogin.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun koinInit(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)

        modules(
            appModule,
            platformModule
        )
    }
}