package com.example.android.marsrealestate.network

import android.os.Parcelable
import androidx.lifecycle.LiveData
import com.example.android.marsrealestate.overview.MarsApiStatus
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * Gets Mars real estate property information from the Mars API Retrofit service and updates the
 * [MarsProperty] and [MarsApiStatus] [LiveData]. The Retrofit service returns a coroutine
 * Deferred, which we await to get the result of the transaction.
 * @param filter the [MarsApiFilter] that is sent as part of the web server request
 */
@Parcelize
data class MarsProperty(
        val id: String,
        @Json(name = "img_src") val imgSrcUrl: String,
        val type: String,
        val price: Double) : Parcelable {
    val isRental
        get() = type == "rent"
}
