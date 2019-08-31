package com.android.core.arch.ui.story.splash


import com.android.core.arch.data.manager.DataManager
import com.android.core.arch.rx.SchedulerProvider

import dagger.Module
import dagger.Provides

/**
 * SplashActivityModule which provide requested dependency to
 * [SplashViewModel] to perform operation
 * @author Rohit Anvekar
 * @since 2019-02-15
 */
@Module
class SplashActivityModule {
    @Provides
    internal fun provideSplashViewModel(dataManager: DataManager,
                                        schedulerProvider: SchedulerProvider): SplashViewModel {
        return SplashViewModel(dataManager, schedulerProvider)
    }
}
