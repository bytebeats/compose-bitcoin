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

internal val timeSpanMap = mapOf(
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
    selectedTimeSpan: QuoteTimeSpan = QuoteTimeSpan.MONTH,
    onTimeSpanSelected: ((QuoteTimeSpan) -> Unit)? = null
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceAround) {
        for (entry in timeSpanMap) {
            TimeSpanChip(
                timeSpan = stringResource(id = entry.key),
                isSelected = selectedTimeSpan == entry.value
            ) {
                onTimeSpanSelected?.invoke(entry.value)
            }
        }
//        TimeSpanChip(
//            timeSpan = stringResource(id = R.string.short_one_day),
//            isSelected = selectedTimeSpan == QuoteTimeSpan.DAY
//        ) {
//            onTimeSpanSelected?.invoke(QuoteTimeSpan.DAY)
//        }
//
//        TimeSpanChip(
//            timeSpan = stringResource(id = R.string.short_seven_days),
//            isSelected = selectedTimeSpan == QuoteTimeSpan.WEEK
//        ) {
//            onTimeSpanSelected?.invoke(QuoteTimeSpan.WEEK)
//        }
//
//        TimeSpanChip(
//            timeSpan = stringResource(id = R.string.short_thirty_days),
//            isSelected = selectedTimeSpan == QuoteTimeSpan.MONTH
//        ) {
//            onTimeSpanSelected?.invoke(QuoteTimeSpan.MONTH)
//        }
//
//        TimeSpanChip(
//            timeSpan = stringResource(id = R.string.short_sixty_days),
//            isSelected = selectedTimeSpan == QuoteTimeSpan.TWO_MONTHS
//        ) {
//            onTimeSpanSelected?.invoke(QuoteTimeSpan.TWO_MONTHS)
//        }
//        TimeSpanChip(
//            timeSpan = stringResource(id = R.string.short_ninety_days),
//            isSelected = selectedTimeSpan == QuoteTimeSpan.THREE_MONTHS
//        ) {
//            onTimeSpanSelected?.invoke(QuoteTimeSpan.THREE_MONTHS)
//        }
//        TimeSpanChip(
//            timeSpan = stringResource(id = R.string.short_one_year),
//            isSelected = selectedTimeSpan == QuoteTimeSpan.ONE_YEAR
//        ) {
//            onTimeSpanSelected?.invoke(QuoteTimeSpan.ONE_YEAR)
//        }
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
                shape = RoundedCornerShape(20.dp)
            )
            .clickable { onTimeSpanSelected?.invoke() },
    ) {
        Text(
            text = timeSpan,
            color = if (isSelected) MaterialTheme.colors.background else MaterialTheme.colors.onBackground,
            modifier = Modifier.padding(8.dp),
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
        selectedTimeSpan = QuoteTimeSpan.MONTH
    )
}