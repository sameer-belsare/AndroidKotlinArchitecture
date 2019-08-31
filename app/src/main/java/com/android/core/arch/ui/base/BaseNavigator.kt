package com.android.core.arch.ui.base

/**
 * BaseNavigator for navigating in between the activity with it's data
 *
 * @author Rohit Anvekar
 * @since 2019-02-14
 */
interface BaseNavigator {

    /**
     * default method to setup views and data.
     */
    fun setupViews()

    /**
     * default method for open next activity.
     */
    fun openNextActivity()

}
