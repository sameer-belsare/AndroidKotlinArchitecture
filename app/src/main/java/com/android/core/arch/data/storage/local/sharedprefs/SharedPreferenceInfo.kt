package com.android.core.arch.data.storage.local.sharedprefs

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

import javax.inject.Qualifier


/**
 * SharedPreferenceInfo qualifier for shared preference
 *
 * @author Rohit Anvekar
 * @since 2019-02-14
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
annotation class SharedPreferenceInfo
