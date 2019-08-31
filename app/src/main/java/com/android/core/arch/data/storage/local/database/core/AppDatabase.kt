package com.android.core.arch.data.storage.local.database.core


import com.android.core.arch.data.storage.local.database.dao.UserDao
import com.android.core.arch.data.storage.local.database.table.User

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Core Room Database class for application
 *
 * @author Rohit Anvekar
 * @since 2019-02-14
 */
@Database(entities = [User::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}
