package com.android.core.arch.data.manager

import android.content.Context
import android.content.SharedPreferences

import com.android.core.arch.data.storage.local.sharedprefs.SharedPrefsService
import com.android.core.arch.data.storage.remote.api.RemoteApiService
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Retrofit

/**
 * DataManager
 *
 * @author Rohit Anvekar
 * @since 2019-02-14
 */
interface DataManager {

    /** Returns an [Context] of [AppCompatActivity].  */
    val context: Context

    /** Returns an [RemoteApiService] of [Retrofit].  */
    val remoteApiService: RemoteApiService

    /** Returns an [SharedPrefsService] of [SharedPreferences]  */
    val sharedPrefsService: SharedPrefsService

}
