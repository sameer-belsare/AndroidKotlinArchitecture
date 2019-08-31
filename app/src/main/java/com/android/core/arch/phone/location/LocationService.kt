package com.android.core.arch.phone.location

import android.content.Context
import android.location.Location
import android.os.Looper

import com.android.core.arch.data.storage.local.sharedprefs.SharedPrefsHelper
import com.android.core.arch.utils.app.AppLogger
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.android.gms.location.LocationCallback
import javax.inject.Inject
import javax.inject.Singleton
import io.reactivex.annotations.NonNull


/**
 * LocationService class for getting phone current location
 * from available location provider like CELL NETWORK or GPS
 * @author Rohit Anvekar
 * @since 2019-02-14
 */

@Singleton
class LocationService @Inject
constructor(private val mContext: Context, mSharedPrefsHelper: SharedPrefsHelper) {

    private val TAG = LocationService::class.java!!.getName()
    private val mSharedPrefsHelper: SharedPrefsHelper? = null
    private var mLocationRequest: LocationRequest? = null
    private var mFusedLocationClient: FusedLocationProviderClient? = null
    private var mLocationCallback: LocationCallback? = null
    var location: Location? = null
        private set

    init {
        var mSharedPrefsHelper = mSharedPrefsHelper
        mSharedPrefsHelper = mSharedPrefsHelper
        startLocationUpdates()
    }

    fun startLocationUpdates() {
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(mContext)

        mLocationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult?) {
                super.onLocationResult(locationResult)
                onNewLocation(locationResult!!.lastLocation)
            }
        }

        createLocationRequest()

        //# Location access way by:
        //Get One time location call back when get called explicitly
        //getLastLocation();

        //# Call once  for periodically updates of location
        //requestLocationUpdates();
    }

    private fun createLocationRequest() {
        mLocationRequest = LocationRequest.create()
        mLocationRequest!!.interval = UPDATE_INTERVAL_IN_MILLISECONDS
        mLocationRequest!!.fastestInterval = FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS
        mLocationRequest!!.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
    }


    /**
     * Makes a request for location updates. Note that in this sample we merely log the
     * [SecurityException].
     */
    fun requestLocationUpdates() {
        AppLogger.i(TAG, "Requesting location updates")
        try {
            mFusedLocationClient!!.requestLocationUpdates(mLocationRequest,
                    mLocationCallback!!, Looper.myLooper())
        } catch (unlikely: SecurityException) {
            AppLogger.e(TAG, "Lost location permission. Could not request updates. $unlikely")
        }

    }

    /**
     * Removes location updates. Note that in this sample we merely log the
     * [SecurityException].
     */
    fun removeLocationUpdates() {
        AppLogger.i(TAG, "Removing location updates")
        try {
            mFusedLocationClient!!.removeLocationUpdates(mLocationCallback!!)
            mLocationCallback = null
        } catch (unlikely: SecurityException) {
            AppLogger.e(TAG, "Lost location permission. Could not remove updates. $unlikely")
        }

    }


    /**
     * get Last Location
     */
    fun getLastLocation() {
        try {
            mFusedLocationClient!!.lastLocation
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful && task.result != null) {
                            location = task.result
                            AppLogger.i(TAG, "getLastLocation Location: Lat: " + location!!.latitude + " Long: " + location!!.longitude)
                        } else {
                            AppLogger.i(TAG, "Failed to get location.")
                        }
                    }
        } catch (unlikely: SecurityException) {
            AppLogger.e(TAG, "Lost location permission.$unlikely")
        }

    }

    private fun onNewLocation(location: Location) {
        this.location = location
        AppLogger.i(TAG, "onNewLocation Location: Lat: " + this.location!!.latitude + " Long: " + this.location!!.longitude)
    }

    companion object {
        private val UPDATE_INTERVAL_IN_MILLISECONDS: Long = 10000
        private val FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = UPDATE_INTERVAL_IN_MILLISECONDS / 2
    }
}
