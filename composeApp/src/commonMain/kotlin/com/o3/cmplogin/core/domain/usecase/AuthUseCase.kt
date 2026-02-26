package com.o3.cmplogin.core.domain.usecase

import com.o3.cmplogin.core.data.repository.AuthRepository

class CheckAuthUseCase(private val repo: AuthRepository) {
    suspend operator fun invoke() = repo.isUserLoggedIn()
}

class LoginUseCase(private val repo: AuthRepository) {
    suspend operator fun invoke(email: String, password: String) =
        repo.login(email, password)
}

class SignUpUseCase(private val repo: AuthRepository) {
    suspend operator fun invoke(email: String, password: String) =
        repo.signup(email, password)
}