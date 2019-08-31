package com.android.core.arch.utils.app

import android.content.res.Resources

/**
 * ViewUtils Class
 * @author  Rohit Anvekar
 * @since   2019-02-14
 */
object ViewUtils {

    fun pxToDp(px: Float): Float {
        val densityDpi = Resources.getSystem().displayMetrics.densityDpi.toFloat()
        return px / (densityDpi / 160f)
    }

    fun dpToPx(dp: Float): Int {
        val density = Resources.getSystem().displayMetrics.density
        return Math.round(dp * density)
    }

}// This class is not publicly instantiable
