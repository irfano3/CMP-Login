package com.o3.cmplogin.database

import androidx.room.Room
import com.o3.cmplogin.core.data.local.db.AppDatabase
import platform.Foundation.NSHomeDirectory

fun getDatabaseBuilder(): AppDatabase {
    val path = NSHomeDirectory() + "/app.db"
    return Room.databaseBuilder(
        name = path
    ).build()
}