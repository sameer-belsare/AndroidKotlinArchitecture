package com.android.core.arch.ui.story.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View

import com.android.core.arch.R
import com.android.core.arch.ui.base.BaseActivity
import com.android.core.arch.ui.story.feed.FeedActivity

import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * Splash Activity is launcher activity which can perform initially configure
 * data and setup stuff for the application
 *
 * @author Rohit Anvekar
 * @since 2019-02-15
 */
class SplashActivity : BaseActivity<SplashViewModel>(), SplashNavigator {

    @Inject
    override lateinit var viewModel: SplashViewModel
        internal set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        viewModel!!.navigator = this
        setupViews()
    }

    override fun setupViews() {
        showSplashView()
    }

    override fun openNextActivity() {
        val launchFeedIntent = Intent(this, FeedActivity::class.java)
        startActivity(launchFeedIntent)
        finish()
    }

    override fun showSplashView() {
        splashProgressBar!!.visibility = View.VISIBLE
        val handler = Handler()
        handler.postDelayed({
            splashProgressBar!!.visibility = View.GONE
            openNextActivity()
        }, 1000)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel!!.onCleared()
    }
}
