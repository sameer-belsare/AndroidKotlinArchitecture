package com.android.core.arch.ui.story.splash

import com.android.core.arch.ui.base.BaseNavigator

/**
 * SplashNavigator to perform ui navigation for [SplashActivity]
 * @author Rohit Anvekar
 * @since 2019-02-15
 */
interface SplashNavigator : BaseNavigator {

    /**
     * Display splash view for some time and
     * then navigate user to next screen.
     */
    fun showSplashView()
}
