package com.android.core.arch.data.storage.local.sharedprefs


/**
 * SharedPrefsHelper
 *
 * @author Rohit Anvekar
 * @since 2019-02-14
 */
interface SharedPrefsHelper {

    /**
     * Set String value against the key
     * @param key
     * @param value
     */
    fun setStringValue(key: String, value: String)

    /**
     * return String against the key
     * @param key
     * @return String
     */
    fun getStringValue(key: String): String
}
