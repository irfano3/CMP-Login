package com.o3.cmplogin.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.o3.cmplogin.core.data.local.entity.UserEntity

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM UserEntity ORDER BY id DESC LIMIT 1")
    suspend fun getLastUser(): UserEntity?
}