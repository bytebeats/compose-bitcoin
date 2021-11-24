package me.bytebeats.compose.bitcoin.viewstate

import android.content.Context
import androidx.annotation.DrawableRes
import me.bytebeats.compose.bitcoin.R
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

/**
 * Created by bytebeats on 2021/11/24 : 14:18
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
class ErrorViewState(private val error: Throwable) {
    @DrawableRes
    fun errorImage(): Int = when (error) {
        is IOException -> R.drawable.ic_no_connection
        else -> R.drawable.ic_error
    }

    fun errorMessage(context: Context): String = when (error) {
        is HttpException -> error.message.orEmpty()
        is SocketTimeoutException -> context.getString(R.string.timeout_error_message)
        is IOException -> context.getString(R.string.no_internet_connection)
        else -> context.getString(R.string.something_went_wrong)
    }
}