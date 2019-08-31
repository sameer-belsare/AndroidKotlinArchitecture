package com.android.core.arch.data.manager

import android.content.Context

import com.android.core.arch.data.storage.local.sharedprefs.SharedPrefsService
import com.android.core.arch.data.storage.remote.api.RemoteApiService

import javax.inject.Inject

/**
 * AppDataManager is implementation of [DataManager]
 *
 * @author Rohit Anvekar
 * @since 2019-02-14
 */
class AppDataManager @Inject
constructor(override val context: Context, override val remoteApiService: RemoteApiService, override val sharedPrefsService: SharedPrefsService) : DataManager
