package me.bytebeats.compose.bitcoin.component

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import me.bytebeats.compose.bitcoin.R
import me.bytebeats.compose.bitcoin.ui.theme.ComposeBitcoinTheme

/**
 * Created by bytebeats on 2021/11/24 : 14:49
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

@Composable
fun PriceHeader(
    modifier: Modifier = Modifier,
    currency: String,
    price: String,
    changeRate: String,
    isChangeRatePositive: Boolean
) {
    ConstraintLayout(modifier = modifier) {
        val (textCurrency, textPrice, imageChangeRate, textChangeRate) = createRefs()
        Text(
            text = currency,
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier.constrainAs(textCurrency) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
            })
        Text(
            text = price,
            style = MaterialTheme.typography.h4,
            modifier = Modifier
                .constrainAs(textPrice) {
                    start.linkTo(parent.start)
                    top.linkTo(textCurrency.bottom)
                }
                .padding(top = 4.dp)
        )
        Image(
            painter = painterResource(id = if (isChangeRatePositive) R.drawable.ic_arrow_positive else R.drawable.ic_arraow_negative),
            contentDescription = null,
            modifier = Modifier
                .constrainAs(imageChangeRate) {
                    top.linkTo(textChangeRate.top)
                    bottom.linkTo(textChangeRate.bottom)
                    end.linkTo(textChangeRate.start)
                    height = Dimension.fillToConstraints
                }
                .padding(4.dp)
        )
        Text(
            text = changeRate,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.constrainAs(textChangeRate) {
                top.linkTo(textPrice.top)
                bottom.linkTo(textPrice.bottom)
                end.linkTo(parent.end)
            })
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
private fun PriceHeaderPreview() {
    ComposeBitcoinTheme {
        PriceHeader(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            currency = stringResource(id = R.string.bitcoin_btc),
            price = "$4798.5678",
            changeRate = "+ 14.76&",
            isChangeRatePositive = true
        )
    }
}