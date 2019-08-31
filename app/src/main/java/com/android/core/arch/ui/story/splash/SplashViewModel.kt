package com.android.core.arch.ui.story.splash

import com.android.core.arch.data.manager.DataManager
import com.android.core.arch.rx.SchedulerProvider
import com.android.core.arch.ui.base.BaseViewModel

/**
 * SplashViewModel for splash activity to manage ui related data in lifecycle
 * conscious way
 * @author Rohit Anvekar
 * @since 2019-02-15
 */
class SplashViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<SplashNavigator>(dataManager, schedulerProvider) {

    override var navigator: SplashNavigator?
        get() = super.navigator
        set(navigator) {
            super.navigator = navigator
        }


    public override fun onCleared() {
        super.onCleared()
    }
}
