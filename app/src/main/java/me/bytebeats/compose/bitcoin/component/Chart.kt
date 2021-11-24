package me.bytebeats.compose.bitcoin.component

import android.content.Context
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.LineDataSet
import me.bytebeats.compose.bitcoin.R
import me.bytebeats.compose.bitcoin.util.ktx.getCompatColor
import me.bytebeats.compose.bitcoin.util.ktx.isInDarkMode
import me.bytebeats.compose.bitcoin.util.ktx.setLineDataSet

/**
 * Created by bytebeats on 2021/11/24 : 17:05
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
@Composable
fun Chart(modifier: Modifier = Modifier, lineDataSet: LineDataSet? = null) {
    AndroidView(
        factory = { context ->
            LineChart(context).apply {
                description.isEnabled = false
                isDragEnabled = false
                xAxis.isEnabled = false
                axisLeft.setDrawAxisLine(false)
                axisLeft.textColor = yAxisLabelTextColor(context)
                axisRight.isEnabled = false
                legend.isEnabled = false
                setTouchEnabled(false)
                setScaleEnabled(false)
                setDrawGridBackground(false)
                setDrawBorders(false)
                invalidate()
                setLineDataSet(lineDataSet)
            }
        }, modifier = modifier
            .fillMaxWidth()
            .requiredHeight(300.dp)
    )
}

private fun yAxisLabelTextColor(context: Context): Int =
    context.getCompatColor(if (context.isInDarkMode()) R.color.white else R.color.gray_950)