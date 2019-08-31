package com.android.core.arch.data.storage.remote.api

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Url

/**
 * RemoteApiHelper
 *
 * @author Rohit Anvekar
 * @since 2019-02-15
 */
interface RemoteApiHelper {

    @GET
    @Headers("Cache-Control: no-cache")
    fun getNewsFeed(@Url fileUrl: String): Observable<ResponseBody>
}