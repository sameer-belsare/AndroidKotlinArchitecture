package com.android.core.arch.data.storage.local.database.dao


import com.android.core.arch.data.storage.local.database.table.User

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * User Dao
 *
 * @author Rohit Anvekar
 * @since 2019-02-14
 */
@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun loadAll(): List<User>

    @Query("SELECT * FROM users WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: List<Int>): List<User>

    @Query("SELECT * FROM users WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<User>)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM users WHERE user_id = :userId LIMIT 1")
    fun loadByIds(userId: String): List<User>
}
