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
import me.bytebeats.compose.bitcoin.enums.QuoteTimeSpan

/**
 * Created by bytebeats on 2021/11/24 : 15:25
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

private val timeSpanMap = mapOf(
    R.string.short_one_day to QuoteTimeSpan.DAY,
    R.string.short_seven_days to QuoteTimeSpan.WEEK,
    R.string.short_thirty_days to QuoteTimeSpan.MONTH,
    R.string.short_sixty_days to QuoteTimeSpan.TWO_MONTHS,
    R.string.short_ninety_days to QuoteTimeSpan.THREE_MONTHS,
    R.string.short_one_year to QuoteTimeSpan.ONE_YEAR,
)

@Composable
fun TimeSpanTab(
    modifier: Modifier = Modifier,
    selectedSpan: QuoteTimeSpan = QuoteTimeSpan.MONTH,
    onSpanSelected: ((QuoteTimeSpan) -> Unit)? = null
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceAround) {
        for (entry in timeSpanMap) {
            TimeSpanChip(
                timeSpan = stringResource(id = entry.key),
                isSelected = selectedSpan == entry.value
            ) {
                onSpanSelected?.invoke(entry.value)
            }
        }
    }
}

@Composable
internal fun TimeSpanChip(
    timeSpan: String,
    isSelected: Boolean,
    onTimeSpanSelected: (() -> Unit)? = null
) {
    Box(
        modifier = Modifier
            .background(
                color = if (isSelected) MaterialTheme.colors.onBackground else MaterialTheme.colors.background,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable { onTimeSpanSelected?.invoke() },
    ) {
        Text(
            text = timeSpan,
            style = MaterialTheme.typography.subtitle1,
            color = if (isSelected) MaterialTheme.colors.background else MaterialTheme.colors.onBackground,
            modifier = Modifier.padding(start = 10.dp, top = 5.dp, end = 10.dp, bottom = 5.dp),
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun TimeSpanTabPreview() {
    TimeSpanTab(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        selectedSpan = QuoteTimeSpan.MONTH
    )
}