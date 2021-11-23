package me.bytebeats.compose.bitcoin.ktx

import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

/**
 * Created by bytebeats on 2021/11/23 : 16:15
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */

private const val DEFAULT_ANIMATE_XY_DURATION = 300
private const val MIN_ENTRY_COUNT_FOR_ANIMATION = 30

fun LineChart.setLineDataSet(lineDataSet: LineDataSet? = null, animateXDuration: Int = 0) {
    lineDataSet?.let {
        clear()
        data = LineData(it).apply { setDrawValues(false) }
    }

    if (lineDataSet?.entryCount.orZero() > MIN_ENTRY_COUNT_FOR_ANIMATION) {
        animateX(if (animateXDuration > 0) animateXDuration else DEFAULT_ANIMATE_XY_DURATION)
    }
}