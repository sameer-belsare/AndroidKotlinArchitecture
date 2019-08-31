package com.android.core.arch.di.module

import android.app.Application
import android.content.Context

import com.android.core.arch.BuildConfig
import com.android.core.arch.data.manager.AppDataManager
import com.android.core.arch.data.manager.DataManager
import com.android.core.arch.data.storage.local.sharedprefs.SharedPrefsHelper
import com.android.core.arch.data.storage.local.sharedprefs.SharedPrefsService
import com.android.core.arch.data.storage.remote.api.RemoteApiHelper
import com.android.core.arch.data.storage.remote.api.RemoteApiService
import com.android.core.arch.data.storage.local.sharedprefs.SharedPreferenceInfo
import com.android.core.arch.rx.AppSchedulerProvider
import com.android.core.arch.rx.SchedulerProvider
import com.android.core.arch.utils.Constants

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Data module which provides following dependencies
 * to perform different operation in app related to data access and storage
 * on local and remote.
 * For Data Management : [AppDataManager]
 * -Local Data access : [SharedPrefsService]
 * -For Remote Data access and Network operations:
 * [RemoteApiService],
 * [Retrofit]
 * [OkHttpClient]
 * For Background operation : [SchedulerProvider]
 * @author Rohit Anvekar
 * @since 2019-02-14
 */
@Module
class DataModule {


    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @SharedPreferenceInfo
    internal fun providePreferenceName(): String {
        return Constants.PREF_NAME
    }

    @Provides
    @Singleton
    internal fun providePreferencesHelper(sharedPrefsService: SharedPrefsService): SharedPrefsHelper {
        return sharedPrefsService
    }

    @Provides
    @Singleton
    internal fun provideHttpCache(application: Application): Cache {
        val cacheSize = BuildConfig.CACHE_SIZE
        return Cache(application.cacheDir, cacheSize.toLong())
    }


    @Provides
    @Singleton
    internal fun provideOkHttpClient(cache: Cache, sharedPrefsService: SharedPrefsService): OkHttpClient {
        val client = OkHttpClient.Builder()
        client.cache(cache)
        return client.build()
    }


    @Provides
    @Singleton
    internal fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BuildConfig.BASE_URL)
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    fun providesRemoteApiHelper(
            retrofit: Retrofit): RemoteApiHelper {
        return retrofit.create(RemoteApiHelper::class.java!!)
    }

    @Provides
    @Singleton
    internal fun provideRemoteApiService(retrofit: Retrofit, remoteApiHelper: RemoteApiHelper): RemoteApiService {
        return RemoteApiService(retrofit, remoteApiHelper)
    }

}