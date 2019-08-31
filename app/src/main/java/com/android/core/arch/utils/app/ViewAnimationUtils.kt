package com.android.core.arch.utils.app

import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation


/**
 * ViewAnimationUtils Class
 * @author  Rohit Anvekar
 * @since   2019-02-14
 */
object ViewAnimationUtils {

    fun scaleAnimateView(view: View) {
        val animation = ScaleAnimation(
                1.15f, 1f, 1.15f, 1f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f)

        view.animation = animation
        animation.duration = 100
        animation.start()
    }

}// This class is not publicly instantiable
