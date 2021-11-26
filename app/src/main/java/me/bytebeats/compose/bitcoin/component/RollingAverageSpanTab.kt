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
import me.bytebeats.compose.bitcoin.enums.RollingAverageSpan

/**
 * Created by bytebeats on 2021/11/24 : 15:25
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

internal val rollingAverageMap = mapOf(
    R.string.short_1_hour to RollingAverageSpan.HOUR,
    R.string.short_4_hours to RollingAverageSpan.FOUR_HOUR,
    R.string.short_8_hours to RollingAverageSpan.EIGHT_HOURS,
    R.string.short_24_hours to RollingAverageSpan.ONE_DAY,
    R.string.short_2_days to RollingAverageSpan.TWO_DAY,
    R.string.short_3_days to RollingAverageSpan.THREE_DAY,
    R.string.short_1_week to RollingAverageSpan.ONE_WEAK,
)

@Composable
fun RollingAverageSpanTab(
    modifier: Modifier = Modifier,
    selectedSpan: RollingAverageSpan = RollingAverageSpan.EIGHT_HOURS,
    onTimeSpanSelected: ((RollingAverageSpan) -> Unit)? = null
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceAround) {
        for (entry in rollingAverageMap) {
            RollingAverageSpanChip(
                rollingAverage = stringResource(id = entry.key),
                isSelected = selectedSpan == entry.value
            ) {
                onTimeSpanSelected?.invoke(entry.value)
            }
        }
    }
}

@Composable
internal fun RollingAverageSpanChip(
    rollingAverage: String,
    isSelected: Boolean,
    onTimeSpanSelected: (() -> Unit)? = null
) {
    Box(
        modifier = Modifier
            .background(
                color = if (isSelected) MaterialTheme.colors.onBackground else MaterialTheme.colors.background,
                shape = RoundedCornerShape(25.dp)
            )
            .clickable { onTimeSpanSelected?.invoke() },
    ) {
        Text(
            text = rollingAverage,
            color = if (isSelected) MaterialTheme.colors.background else MaterialTheme.colors.onBackground,
            modifier = Modifier.padding(10.dp),
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun RollingAverageSpanTabPreview() {
    RollingAverageSpanTab(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        selectedSpan = RollingAverageSpan.EIGHT_HOURS
    )
}