package com.o3.cmplogin.di

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.auth
import org.koin.dsl.module

actual val platformModule = module {
    single<FirebaseAuth> { Firebase.auth }
}