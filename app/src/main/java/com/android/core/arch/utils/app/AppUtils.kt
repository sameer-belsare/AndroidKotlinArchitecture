package com.android.core.arch.utils.app

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.android.core.arch.R
import java.util.ArrayList

/**
 * App Utils Class
 * @author  Rohit Anvekar
 * @since   2019-02-14
 */
object AppUtils {

    /**
     * check if index is within the bounds of [ArrayList] if yes then true else false.
     * @param arrayList
     * @return
     */
    fun isIndexWithInBounds(arrayList: ArrayList<*>, index: Int): Boolean {

        return index >= 0 && index < arrayList.size
    }

    /**
     * check if [ArrayList] is not null and empty then return true else false.
     * @param list
     * @return
     */
    fun isListNotNullEmpty(list: ArrayList<*>?): Boolean {

        return if (list != null && !list.isEmpty()) {
            true
        } else false
    }

    /**
     * check if [java.util.List] is not null and empty then return true else false.
     * @param list
     * @return
     */
    fun isListNotNullEmpty(list: List<*>?): Boolean {

        return if (list != null && !list.isEmpty()) {
            true
        } else false
    }

    fun openPlayStoreForApp(context: Context) {
        val appPackageName = context.packageName
        try {
            context.startActivity(Intent(Intent.ACTION_VIEW,
                    Uri.parse(context
                            .resources
                            .getString(R.string.app_market_link) + appPackageName)))
        } catch (e: android.content.ActivityNotFoundException) {
            context.startActivity(Intent(Intent.ACTION_VIEW,
                    Uri.parse(context
                            .resources
                            .getString(R.string.app_google_play_store_link) + appPackageName)))
        }

    }
}// This class is not publicly instantiable
