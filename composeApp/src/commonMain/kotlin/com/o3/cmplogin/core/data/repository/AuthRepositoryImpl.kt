package com.o3.cmplogin.core.data.repository

import com.o3.cmplogin.core.data.local.dao.UserDao
import com.o3.cmplogin.core.data.local.entity.UserEntity
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth

//class AuthRepositoryImpl(
//    private val firebaseAuth: FirebaseAuth = Firebase.auth
//) : AuthRepository {
//
//    override suspend fun isUserLoggedIn(): Boolean {
//        return firebaseAuth.currentUser != null
//    }
//
//    override suspend fun login(email: String, password: String): Result<Unit> {
//        return try {
//            firebaseAuth.signInWithEmailAndPassword(email, password)
//            Result.success(Unit)
//        } catch (e: Exception) {
//            Result.failure(e)
//        }
//    }
//
//    override suspend fun signup(email: String, password: String): Result<Unit> {
//        return try {
//            firebaseAuth.createUserWithEmailAndPassword(email, password)
//            Result.success(Unit)
//        } catch (e: Exception) {
//            Result.failure(e)
//        }
//    }
//}

class AuthRepositoryImpl(
    private val userDao: UserDao,
    private val firebaseAuth: FirebaseAuth = Firebase.auth
) : AuthRepository {

    override suspend fun isUserLoggedIn(): Boolean {
        return firebaseAuth.currentUser != null
    }

    override suspend fun login(email: String, password: String): Result<Unit> {
        return try {
            firebaseAuth.signInWithEmailAndPassword(email, password)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun signup(email: String, password: String): Result<Unit> {
        return try {

            firebaseAuth.createUserWithEmailAndPassword(email, password)

            userDao.insertUser(
                UserEntity(
                    email = email,
                    password = password
                )
            )

            Result.success(Unit)

        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getLastUser(): UserEntity? {
        return userDao.getLastUser()
    }
}