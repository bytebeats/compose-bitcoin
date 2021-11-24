package me.bytebeats.compose.bitcoin.util.ktx

import android.content.Context
import android.content.res.Configuration
import android.graphics.drawable.Drawable
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

/**
 * Created by bytebeats on 2021/11/23 : 16:08
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

internal fun Context.getCompatColor(@ColorRes id: Int): Int = ContextCompat.getColor(this, id)

internal fun Context.getCompatDrawable(@DrawableRes id: Int): Drawable? =
    ContextCompat.getDrawable(this, id)

internal fun Context.isNetworkAvailable(): Boolean = try {
    val connManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        connManager.activeNetwork?.let { network ->
            connManager.getNetworkCapabilities(network)?.let { nc ->
                nc.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || nc.hasTransport(
                    NetworkCapabilities.TRANSPORT_CELLULAR
                ) || nc.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
            } ?: false
        } ?: false
    } else {
        true
    }
} catch (e: Exception) {
    false
}

internal fun Context.isInDarkMode(): Boolean =
    this.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES