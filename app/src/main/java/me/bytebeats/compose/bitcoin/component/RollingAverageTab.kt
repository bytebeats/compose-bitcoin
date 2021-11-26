package me.bytebeats.compose.bitcoin.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.bytebeats.compose.bitcoin.R
import me.bytebeats.compose.bitcoin.enums.RollingAverage

/**
 * Created by bytebeats on 2021/11/24 : 15:25
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

private val rollingAverageMap = mapOf(
    R.string.short_1_hour to RollingAverage.HOUR,
    R.string.short_4_hours to RollingAverage.FOUR_HOUR,
    R.string.short_8_hours to RollingAverage.EIGHT_HOURS,
    R.string.short_24_hours to RollingAverage.ONE_DAY,
    R.string.short_2_days to RollingAverage.TWO_DAY,
    R.string.short_3_days to RollingAverage.THREE_DAY,
    R.string.short_1_week to RollingAverage.ONE_WEAK,
)

@Composable
fun RollingAverageTab(
    modifier: Modifier = Modifier,
    selectedSpan: RollingAverage = RollingAverage.EIGHT_HOURS,
    onSpanSelected: ((RollingAverage) -> Unit)? = null
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceAround) {
        for (entry in rollingAverageMap) {
            RollingAverageChip(
                rollingAverage = stringResource(id = entry.key),
                isSelected = selectedSpan == entry.value
            ) {
                onSpanSelected?.invoke(entry.value)
            }
        }
    }
}

@Composable
internal fun RollingAverageChip(
    rollingAverage: String,
    isSelected: Boolean,
    onSpanSelected: (() -> Unit)? = null
) {
    Box(
        modifier = Modifier
            .background(
                color = if (isSelected) MaterialTheme.colors.onBackground else MaterialTheme.colors.background,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable { onSpanSelected?.invoke() },
    ) {
        Text(
            text = rollingAverage,
            style = MaterialTheme.typography.subtitle1,
            color = if (isSelected) MaterialTheme.colors.background else MaterialTheme.colors.onBackground,
            modifier = Modifier.padding(start = 10.dp, top = 5.dp, end = 10.dp, bottom = 5.dp),
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun RollingAverageTabPreview() {
    RollingAverageTab(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        selectedSpan = RollingAverage.EIGHT_HOURS
    )
}