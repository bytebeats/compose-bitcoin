package me.bytebeats.compose.bitcoin.ktx

import android.content.res.Resources
import android.view.View
import android.view.ViewStub
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

/**
 * Created by bytebeats on 2021/11/23 : 16:20
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
fun ImageView.setDrawableRes(@DrawableRes drawableRes: Int?) {
    if (drawableRes.isNotNull() && drawableRes != Resources.ID_NULL) {
        this.setImageDrawable(this.context.getCompatDrawable(drawableRes!!))
    }
}

fun SwipeRefreshLayout.isRefreshing(refreshing: Boolean) {
    this.isRefreshing = refreshing
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun ViewStub.inflate(inflate: Boolean) {
    if (inflate) {
        inflate()
    }
}