package com.android.core.arch.data.storage.local.database.core

import com.android.core.arch.data.storage.local.database.table.User
import java.util.concurrent.Callable

import javax.inject.Inject
import javax.inject.Singleton

import io.reactivex.Observable


/**
 * AppDBsHelper
 *
 * @author Rohit Anvekar
 * @since 2019-02-14
 */
@Singleton
class AppDbHelper @Inject
constructor(private val mAppDatabase: AppDatabase) : DbHelper {

    override val allUsers: Observable<List<User>>
        get() = Observable.fromCallable { mAppDatabase.userDao().loadAll() }


    override fun insertUser(user: User): Observable<Boolean> {
        return Observable.fromCallable {
            mAppDatabase.userDao().insert(user)
            true
        }
    }


    override fun getUserById(userId: String): Observable<List<User>> {
        return Observable.fromCallable { mAppDatabase.userDao().loadByIds(userId) }
    }

}
