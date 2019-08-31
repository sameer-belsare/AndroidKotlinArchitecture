package com.android.core.arch.utils.app

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle

/**
 * Activity constants
 * @author  Rohit Anvekar
 * @since   2019-02-14
 */
object ActivityUtils {

    /**
     * Method to start new activity with passed bundle and boolean variable to decide whether to
     * finish the activity or not
     *
     * @param context        Current Activity Context
     * @param clazz          Activity to be started
     * @param bundle         Bundle data to be passed to new Activity
     * @param finishActivity boolean variable to decide whether to finish the activity or not
     */
    @JvmOverloads
    fun goToNextActivity(context: Context, clazz: Class<*>, bundle: Bundle? = null, finishActivity: Boolean = false) {
        val intent = Intent(context, clazz)

        if (bundle != null) {
            intent.putExtras(bundle)
        }
        context.startActivity(intent)
        if (finishActivity && context is Activity) {
            context.finish()
        }
    }


    /**
     * to check value of intent bundle.
     *
     * @param intent
     * @return
     */
    fun isIntentBundleAvailable(intent: Intent?): Boolean {
        return if (intent != null && intent.extras != null) true else false
    }

    /**
     * Method to  start activity by setting request code to return when
     * result code send back towards the starting point be in it's previous
     * screen without any flow break.
     *
     * @param activity
     * @param clazz
     * @param code
     */
    fun startActivityForResult(activity: Activity, clazz: Class<*>, bundle: Bundle, code: Int) {
        val intent = Intent(activity, clazz)
        intent.putExtras(bundle)
        activity.startActivityForResult(intent, code)
    }

    /**
     * Method to start new activity with passed bundle and boolean variables to decide whether to
     * clear backstack and finish the activity or not
     *
     * @param context        Current Activity Context
     * @param clazz          Activity to be started
     * @param bundle         Bundle data to be passed to new Activity
     * @param finishActivity boolean variable to decide whether to finish the activity or not
     * @param clearBackstack boolean variable to decide whether to clear the backstack or not
     */
    fun goToNextActivity(context: Context, clazz: Class<*>, bundle: Bundle?, finishActivity: Boolean, clearBackstack: Boolean) {
        val intent = Intent(context, clazz)

        if (clearBackstack) {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        context.startActivity(intent)
        if (finishActivity && context is Activity) {
            context.finish()
        }
    }

}
/**
 * Method to start new activity without bundle and without finishing the current one
 *
 * @param context Current Activity Context
 * @param clazz   Activity to be started
 */
/**
 * Method to start new activity with passed bundle and without finishing the current activity
 *
 * @param context Current Activity Context
 * @param clazz   Activity to be started
 * @param bundle  Bundle data to be passed to new Activity
 */
