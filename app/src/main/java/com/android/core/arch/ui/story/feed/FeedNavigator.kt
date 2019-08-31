package com.android.core.arch.ui.story.feed

import com.android.core.arch.ui.base.BaseNavigator

import androidx.annotation.StringRes

/**
 * @author Rohit Anvekar
 * @since 2019-02-16
 */
interface FeedNavigator : BaseNavigator {

    /**
     * Display feeds in recycle view.
     *
     */
    fun displayFeeds()

    /**
     * Display progress on activity.
     * @param visibility
     */
    fun displayProgress(visibility: Int)

    /**
     *
     * Display message on activity.
     * @param messageResId
     */
    fun displayMessage(@StringRes messageResId: Int)
}
