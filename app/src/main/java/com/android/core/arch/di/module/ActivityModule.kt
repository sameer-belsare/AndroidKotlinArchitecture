package com.android.core.arch.di.module

import com.android.core.arch.ui.story.feed.FeedActivity
import com.android.core.arch.ui.story.feed.FeedActivityModule
import com.android.core.arch.ui.story.splash.SplashActivity
import com.android.core.arch.ui.story.splash.SplashActivityModule

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * ActivityModule provides android injection of it's module in activity.
 *
 * @author Rohit Anvekar
 * @since 2019-02-15
 */
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    internal abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [FeedActivityModule::class])
    internal abstract fun bindFeedActivity(): FeedActivity
}
