package me.bytebeats.compose.bitcoin.util.ktx

import android.content.Context
import android.content.res.Configuration
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

/**
 * Created by bytebeats on 2021/11/23 : 16:08
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

fun Context.getCompatColor(@ColorRes id: Int): Int = ContextCompat.getColor(this, id)

fun Context.getCompatDrawable(@DrawableRes id: Int): Drawable? = ContextCompat.getDrawable(this, id)

fun Context.isInDarkMode(): Boolean =
    this.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES