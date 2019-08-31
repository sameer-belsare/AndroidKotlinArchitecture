package com.android.core.arch.utils.app

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo


/**
 * NetworkUtils Class
 * @author  Rohit Anvekar
 * @since   2019-02-14
 */
object NetworkUtils {

    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }
}// This class is not publicly instantiable
