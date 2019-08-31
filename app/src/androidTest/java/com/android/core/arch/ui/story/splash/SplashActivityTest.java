package com.android.core.arch.ui.story.splash;

import com.android.core.arch.R;

import org.junit.Rule;
import org.junit.Test;

import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

/**
 * SplashActivityTest
 *
 * @author Rohit Anvekar
 * @since 2019-02-16
 */
public class SplashActivityTest {

    @Rule
    public ActivityTestRule<SplashActivity> mSplashActivityTestRule = new ActivityTestRule<>(SplashActivity.class);


    @Test
    public void testViewShouldDisplayed() {
        onView(withId(R.id.splashProgressBar)).check(matches(isDisplayed()));
    }

}