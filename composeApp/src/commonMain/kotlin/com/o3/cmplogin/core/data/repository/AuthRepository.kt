package com.o3.cmplogin.core.data.repository

interface AuthRepository {
    suspend fun isUserLoggedIn(): Boolean
    suspend fun login(email: String, password: String): Result<Unit>
    suspend fun signup(email: String, password: String): Result<Unit>
}