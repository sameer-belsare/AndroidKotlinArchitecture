package com.android.core.arch


import com.android.core.arch.di.component.DaggerAppComponent

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * CoreApplication class for maintaining global application state and
 * generating necessary dependency for app
 *
 * @author Rohit Anvekar
 * @since 2019-02-14
 */
class CoreApplication : DaggerApplication() {

    override fun applicationInjector() : AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

    override fun onCreate() {
        super.onCreate()
    }
}


