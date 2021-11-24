package me.bytebeats.compose.bitcoin.util.ktx

import java.text.NumberFormat
import java.util.*

/**
 * Created by bytebeats on 2021/11/23 : 15:52
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

fun Boolean.doIfTrue(action: (() -> Unit)? = null) {
    if (this) {
        action?.invoke()
    }
}

fun Boolean?.orFalse(): Boolean = this ?: false

fun Double?.orZero(): Double = this ?: 0.0

fun Double?.toCurrency(locale: Locale = Locale.US): String {
    return NumberFormat.getCurrencyInstance(locale).format(this.orZero()).orEmpty()
}

/**
 * Round with decimals
 *
 * @param decimals
 * @return
 */
fun Double.round(decimals: Int = 2): Double = "%.$decimals".format(Locale.US, this).toDouble()

fun Double.changeRateOf(number: Double): Double =
    (((number.minus(this)).div(this)).times(100)).round(2)

fun Int?.orZero(): Int = this ?: 0

fun Any?.isNull(): Boolean = this == null
fun Any?.isNotNull(): Boolean = this != null