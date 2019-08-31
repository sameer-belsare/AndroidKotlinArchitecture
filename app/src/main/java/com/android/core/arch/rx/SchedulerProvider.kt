package com.android.core.arch.rx

import io.reactivex.Scheduler

/**
 * SchedulerProvider with different scheduler option
 * @author  Rohit Anvekar
 * @since   2019-02-14
 */
interface SchedulerProvider {

    fun ui(): Scheduler

    fun computation(): Scheduler

    fun io(): Scheduler
}
