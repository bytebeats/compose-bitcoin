package me.bytebeats.compose.bitcoin.feature

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import me.bytebeats.compose.bitcoin.viewstate.ErrorViewState
import java.io.IOException

/**
 * Created by bytebeats on 2021/11/24 : 10:23
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier,
    errorViewState: ErrorViewState,
    onTryAgain: (() -> Unit)? = null
) {
    val scrollState = rememberScrollState()
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
            Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
                    .fillMaxWidth()
                    .heightIn(max = 100.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = errorViewState.errorMessage(LocalContext.current),
                    style = MaterialTheme.typography.body1,
                    color = Gray700,
                )
            }
            Button(
                onClick = { onTryAgain?.invoke() },
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

@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ErrorScreenPreview() {
    ComposeBitcoinTheme {
        ErrorScreen(errorViewState = ErrorViewState(IOException("Sorry, IOException!")))
    }
}