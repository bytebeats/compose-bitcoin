package me.bytebeats.compose.bitcoin.viewstate

import android.content.Context
import com.github.mikephil.charting.data.LineDataSet
import me.bytebeats.compose.bitcoin.model.StatsDetail

/**
 * Created by bytebeats on 2021/11/24 : 14:19
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
class StatsViewState(val statsDetail: StatsDetail) {
    fun lineDataSet(context: Context): LineDataSet =
        LineDataSet(statsDetail.transactionsEntries, "transactions_per_second").apply {
            mode = LineDataSet.Mode.CUBIC_BEZIER
//            color = getColor(context)
//            highLightColor = getColor(context)
//            fillDrawable = getBackground(context)
            lineWidth = 1F
            setDrawFilled(true)
            setDrawCircles(false)
        }
}