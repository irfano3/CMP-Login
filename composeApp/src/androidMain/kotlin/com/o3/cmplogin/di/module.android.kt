package com.o3.cmplogin.di

import com.o3.cmplogin.core.data.local.db.AppDatabase
import com.o3.cmplogin.core.data.repository.AuthRepository
import com.o3.cmplogin.core.data.repository.AuthRepositoryImpl
import com.o3.cmplogin.data.getDatabaseBuilder
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.auth
import org.koin.dsl.module

actual val platformModule = module {

    single { getDatabaseBuilder(get()) }

    single { get<AppDatabase>().userDao() }

}