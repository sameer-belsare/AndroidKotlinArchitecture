package com.android.core.arch.data.storage.local.database.core


import com.android.core.arch.data.storage.local.database.table.User

import io.reactivex.Observable


/**
 * DBHelper Class
 *
 * @author Rohit Anvekar
 * @since 2019-02-14
 */
interface DbHelper {

    val allUsers: Observable<List<User>>

    fun insertUser(user: User): Observable<Boolean>

    fun getUserById(userId: String): Observable<List<User>>

}
