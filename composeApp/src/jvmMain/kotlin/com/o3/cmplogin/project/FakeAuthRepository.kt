package com.o3.cmplogin.project

import com.o3.cmplogin.core.data.repository.AuthRepository

class FakeAuthRepository : AuthRepository {

    private val fakeEmail = "test@user.com"
    private val fakePassword = "123456"
    private var loggedIn = false

    override suspend fun isUserLoggedIn(): Boolean = loggedIn

    override suspend fun login(email: String, password: String): Result<Unit> {
        return if (email == fakeEmail && password == fakePassword) {
            loggedIn = true
            Result.success(Unit)
        } else {
            Result.failure(Exception("Invalid credentials"))
        }
    }

    override suspend fun signup(email: String, password: String): Result<Unit> {
        return if (email == fakeEmail && password == fakePassword) {
            loggedIn = true
            Result.success(Unit)
        } else {
            Result.failure(Exception("Invalid signup credentials"))
        }
    }
}