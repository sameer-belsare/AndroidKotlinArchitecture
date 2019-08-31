package com.android.core.arch.di.component

import android.app.Application

import com.android.core.arch.CoreApplication
import com.android.core.arch.di.module.ActivityModule
import com.android.core.arch.di.module.DataModule

import javax.inject.Singleton

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

/**
 * Application component  enable selected modules to perform dependency injection
 * in application
 *
 * @author Rohit Anvekar
 * @since 2019-02-14
 */
@Singleton
@Component(modules = [AndroidInjectionModule::class, ActivityModule::class, DataModule::class])
interface AppComponent : AndroidInjector<CoreApplication> {

    // Gives us syntactic sugar. we can then do DaggerAppComponent.builder().application(this).build().inject(this);
    // never having to instantiate any modules or say which module we are passing the application to.
    // Application will just be provided into our app graph now.
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}

