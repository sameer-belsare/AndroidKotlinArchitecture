package com.android.core.arch.ui.story.feed

import android.os.Bundle
import android.view.View

import com.android.core.arch.R
import com.android.core.arch.ui.base.BaseActivity
import com.google.android.material.snackbar.Snackbar

import javax.inject.Inject
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.android.synthetic.main.activity_feeds.*

/**
 * FeedActivity to render latest feed from available
 * end point file and displayed in list form to user
 *
 * @author Rohit Anvekar
 * @since 2019-02-16
 */
class FeedActivity : BaseActivity<FeedViewModel>(), FeedNavigator, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    override lateinit var viewModel: FeedViewModel
        internal set

    @Inject
    lateinit var mFeedAdapter: FeedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feeds)
        //ButterKnife.bind(this)
        viewModel!!.navigator = this
        setupViews()
    }

    override fun setupViews() {
        feedSwipeRefreshView!!.setOnRefreshListener(this)
        feedRecyclerView!!.layoutManager = LinearLayoutManager(this)
        displayProgress(View.VISIBLE)
        viewModel!!.getLatestFeed()
    }

    override fun openNextActivity() {

    }

    override fun displayFeeds() {
        if (viewModel!!.feed != null) {
            title = viewModel!!.feed!!.title
            mFeedAdapter!!.addFeeds(viewModel!!.feed)
            feedRecyclerView!!.adapter = mFeedAdapter
        }
        displayProgress(View.GONE)
        feedSwipeRefreshView!!.isRefreshing = false
    }

    override fun displayProgress(visibility: Int) {
        feedProgressBar!!.visibility = visibility
    }

    override fun displayMessage(messageResId: Int) {
        Snackbar.make(feedSwipeRefreshView!!, messageResId, Snackbar.LENGTH_LONG)
                .setAction(R.string.try_again) {
                    feedSwipeRefreshView!!.isRefreshing = true
                    viewModel!!.getLatestFeed()
                }
                .show()
    }

    override fun onRefresh() {
        viewModel!!.getLatestFeed()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel!!.onCleared()
    }
}
