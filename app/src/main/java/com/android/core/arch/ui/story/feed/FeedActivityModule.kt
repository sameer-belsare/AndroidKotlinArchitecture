package com.android.core.arch.ui.story.feed

import android.content.Context

import com.android.core.arch.data.manager.DataManager
import com.android.core.arch.rx.SchedulerProvider

import dagger.Module
import dagger.Provides


/**
 * FeedActivityModule which provide requested dependency to
 * [FeedViewModel] to perform operation
 *
 * @author Rohit Anvekar
 * @since 2019-02-16
 */
@Module
class FeedActivityModule {
    @Provides
    internal fun provideFeedViewModel(dataManager: DataManager,
                                      schedulerProvider: SchedulerProvider): FeedViewModel {
        return FeedViewModel(dataManager, schedulerProvider)
    }

    @Provides
    internal fun provideFeedAdapter(context: Context): FeedAdapter {
        return FeedAdapter(context)
    }
}