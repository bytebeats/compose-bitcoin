package me.bytebeats.compose.bitcoin.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import me.bytebeats.compose.bitcoin.R
import me.bytebeats.compose.bitcoin.ui.theme.ComposeBitcoinTheme
import me.bytebeats.compose.bitcoin.ui.theme.Gray700

/**
 * Created by bytebeats on 2021/11/24 : 15:48
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

@Composable
fun Price(
    modifier: Modifier = Modifier,
    openPrice: String,
    closePrice: String,
    highestPrice: String,
    lowestPrice: String,
    averagePrice: String,
    changePrice: String,
) {
    ConstraintLayout(modifier = modifier) {
        val (divider,
            textPrice,
            textOpen,
            textOpenPrice,
            textHigh,
            textHighestPrice,
            textAverage,
            textAveragePrice,
            textClose,
            textClosePrice,
            textLow,
            textLowestPrice,
            textChange,
            textChangePrice) = createRefs()
        Text(
            text = stringResource(id = R.string.price),
            style = MaterialTheme.typography.h5,
            modifier = Modifier.constrainAs(textPrice) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            })
        Text(
            text = stringResource(id = R.string.open),
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier
                .constrainAs(textOpen) {
                    top.linkTo(textPrice.bottom)
                    start.linkTo(parent.start)
                }
                .padding(top = 10.dp)
        )
        Text(
            text = openPrice,
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier
                .constrainAs(textOpenPrice) {
                    top.linkTo(textOpen.top)
                    bottom.linkTo(textOpen.bottom)
                    end.linkTo(divider.start)
                }
                .padding(top = 10.dp, end = 15.dp)
        )
        Text(
            text = stringResource(id = R.string.high),
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier
                .constrainAs(textHigh) {
                    top.linkTo(textOpen.bottom)
                    start.linkTo(parent.start)
                }
                .padding(top = 10.dp)
        )
        Text(
            text = highestPrice,
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier
                .constrainAs(textHighestPrice) {
                    top.linkTo(textHigh.top)
                    bottom.linkTo(textHigh.bottom)
                    end.linkTo(divider.start)
                }
                .padding(top = 10.dp, end = 15.dp)
        )
        Text(
            text = stringResource(id = R.string.average),
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier
                .constrainAs(textAverage) {
                    top.linkTo(textHigh.bottom)
                    start.linkTo(parent.start)
                }
                .padding(top = 10.dp)
        )
        Text(
            text = averagePrice,
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier
                .constrainAs(textAveragePrice) {
                    top.linkTo(textAverage.top)
                    bottom.linkTo(textAverage.bottom)
                    end.linkTo(divider.start)
                }
                .padding(top = 10.dp, end = 15.dp)
        )
        Text(
            text = stringResource(id = R.string.close),
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier
                .constrainAs(textClose) {
                    top.linkTo(textPrice.bottom)
                    start.linkTo(divider.end)
                }
                .padding(top = 10.dp, start = 15.dp)
        )
        Text(
            text = closePrice,
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier
                .constrainAs(textClosePrice) {
                    top.linkTo(textClose.top)
                    bottom.linkTo(textClose.bottom)
                    end.linkTo(parent.end)
                }
                .padding(top = 10.dp)
        )
        Text(
            text = stringResource(id = R.string.low),
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier
                .constrainAs(textLow) {
                    top.linkTo(textClose.bottom)
                    start.linkTo(divider.end)
                }
                .padding(top = 10.dp, start = 15.dp)
        )
        Text(
            text = lowestPrice,
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier
                .constrainAs(textLowestPrice) {
                    top.linkTo(textLow.top)
                    bottom.linkTo(textLow.bottom)
                    end.linkTo(parent.end)
                }
                .padding(top = 10.dp)
        )
        Text(
            text = stringResource(id = R.string.change),
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier
                .constrainAs(textChange) {
                    top.linkTo(textLow.bottom)
                    start.linkTo(divider.end)
                }
                .padding(top = 10.dp, start = 15.dp)
        )
        Text(
            text = changePrice,
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier
                .constrainAs(textChangePrice) {
                    top.linkTo(textChange.top)
                    bottom.linkTo(textChange.bottom)
                    end.linkTo(parent.end)
                }
                .padding(top = 10.dp)
        )
        Divider(modifier = Modifier
            .constrainAs(divider) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(textOpen.top)
                bottom.linkTo(textAverage.bottom)
                height = Dimension.fillToConstraints
            }
            .padding(top = 10.dp)
            .width(0.5.dp)
            .background(Gray700))
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PricePreview() {
    ComposeBitcoinTheme {
        Price(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            openPrice = "150",
            closePrice = "162",
            highestPrice = "175",
            lowestPrice = "143",
            averagePrice = "158",
            changePrice = "12"
        )
    }
}