package com.android.core.arch.ui.story.feed

import android.text.TextUtils

import com.android.core.arch.BuildConfig
import com.android.core.arch.R
import com.android.core.arch.data.manager.DataManager
import com.android.core.arch.rx.SchedulerProvider
import com.android.core.arch.ui.base.BaseViewModel
import com.android.core.arch.ui.story.feed.model.Feeds
import com.android.core.arch.utils.Constants
import com.google.gson.Gson

import io.reactivex.disposables.Disposable

/**
 * FeedViewModel will process data through [DataManager] and
 * do business operation for activity [FeedActivity]
 * which is attached to this view model.
 *
 * @author Rohit Anvekar
 * @see BaseViewModel
 *
 * @see FeedNavigator
 *
 * @since 2019-02-16
 */
class FeedViewModel
/**
 * FeedViewModel Constructor
 *
 * @param dataManager
 * @param schedulerProvider
 */
(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<FeedNavigator>(dataManager, schedulerProvider) {

    var feed: Feeds? = null
        private set

    /**
     * Fetch news feed from endpoint file and saved it to pref and send call back
     * to appropriate method of to display the feeds.
     */
    fun getLatestFeed() {
        val feedsDisposable = dataManager
                .remoteApiService
                .getNewsFeed(BuildConfig.FEED_BASE_URL)
                .doOnNext { responseBody -> saveFeeds(responseBody.string()) }
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(
                        { responseBody ->
                            loadFeeds()
                            navigator!!.displayFeeds()
                        },
                        { throwable ->
                            throwable.printStackTrace()
                            loadFeeds()
                            navigator!!.displayFeeds()
                            navigator!!.displayMessage(R.string.fail_to_load_latest_feeds)
                        })
        compositeDisposable.add(feedsDisposable)
    }

    /**
     * saveFeeds method to save feed json in [android.content.SharedPreferences]
     *
     * @param feedJson
     */
    fun saveFeeds(feedJson: String) {
        if (!TextUtils.isEmpty(feedJson)) {
            dataManager.sharedPrefsService.setStringValue(Constants.PREF_KEY_FEEDS, feedJson)
        } else {
            navigator!!.displayMessage(R.string.fail_to_load_latest_feeds)
        }
    }

    /**
     * loadFeeds method to get feed from [android.content.SharedPreferences]
     */
    fun loadFeeds(): Feeds? {
        val gson = Gson()
        feed = gson.fromJson<Feeds>(dataManager.sharedPrefsService.getStringValue(Constants.PREF_KEY_FEEDS), Feeds::class.java!!)
        return feed
    }

    public override fun onCleared() {
        super.onCleared()
    }

    companion object {

        val TAG = FeedViewModel::class.java!!.getName()
    }
}
