package com.android.core.arch.ui.base

import android.annotation.TargetApi
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle

import java.util.ArrayList
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import dagger.android.AndroidInjection


/**
 * Base class for app activities that use the common feature like action bar and theme
 * with some common function support which needs to available to activity.
 *
 * @author Rohit Anvekar
 * @since 2019-02-14
 */
abstract class BaseActivity<V : BaseViewModel<*>> : AppCompatActivity() {

    private val mViewModel: V? = null

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    abstract val viewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(newBase)
    }


    @TargetApi(Build.VERSION_CODES.M)
    fun requestPermissionsSafely(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode)
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermission(permission: String): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }

    fun checkForPermissions(permissions: Array<String>, permissionRequestCode: Int): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            var result: Int
            val listPermissions = ArrayList<String>()
            for (permission in permissions) {
                result = ContextCompat.checkSelfPermission(this, permission)
                if (result != PackageManager.PERMISSION_GRANTED) {
                    listPermissions.add(permission)
                }
            }
            if (!listPermissions.isEmpty()) {
                requestPermissionsSafely(listPermissions.toTypedArray<String>(), permissionRequestCode)
                return false
            }
        }
        return true
    }

    fun performDependencyInjection() {
        AndroidInjection.inject(this)
    }

    companion object {

        val TAG = BaseActivity::class.java!!.getName()
    }


}
