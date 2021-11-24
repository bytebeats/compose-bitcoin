package me.bytebeats.compose.bitcoin.feature

import android.content.Context
import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.bytebeats.compose.bitcoin.R
import me.bytebeats.compose.bitcoin.ui.theme.ComposeBitcoinTheme
import me.bytebeats.compose.bitcoin.ui.theme.Gray700
import me.bytebeats.compose.bitcoin.ui.theme.Gray900
import me.bytebeats.compose.bitcoin.ui.theme.White
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

/**
 * Created by bytebeats on 2021/11/24 : 10:23
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

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier,
    errorViewState: ErrorViewState,
    onTryAgain: () -> Unit
) {
    Surface(modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = errorViewState.errorImage()),
                contentDescription = errorViewState.errorMessage(
                    LocalContext.current
                ),
            )
            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = errorViewState.errorMessage(LocalContext.current),
                style = MaterialTheme.typography.body1,
                color = Gray700,
            )
            Button(
                onClick = onTryAgain,
                modifier = Modifier
                    .width(250.dp)
                    .padding(top = 16.dp)
                    .background(
                        Gray900, RoundedCornerShape(4.dp)
                    )
            ) {
                Text(
                    text = stringResource(id = R.string.try_again),
                    style = MaterialTheme.typography.button,
                    color = White
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ErrorScreenPreview() {
    ComposeBitcoinTheme {
        ErrorScreen(errorViewState = ErrorViewState(IOException("Sorry, IOException!"))) {

        }
    }
}