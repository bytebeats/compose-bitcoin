package me.bytebeats.compose.bitcoin.viewstate

import android.content.Context
import android.util.Log
import com.github.mikephil.charting.data.LineDataSet
import me.bytebeats.compose.bitcoin.R
import me.bytebeats.compose.bitcoin.model.StatsDetail
import me.bytebeats.compose.bitcoin.util.APP_TAG
import me.bytebeats.compose.bitcoin.util.ktx.getCompatColor
import me.bytebeats.compose.bitcoin.util.ktx.isInDarkMode

/**
 * Created by bytebeats on 2021/11/24 : 14:19
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
class StatsViewState(val statsDetail: StatsDetail) {
    init {
        Log.i(APP_TAG, statsDetail.toString())
    }

    fun lineDataSet(context: Context): LineDataSet =
        LineDataSet(statsDetail.transactionsEntries, "transactions_per_second").apply {
            mode = LineDataSet.Mode.CUBIC_BEZIER
            color =
                context.getCompatColor(if (context.isInDarkMode()) R.color.purple_500 else R.color.purple_200)
            highLightColor = context.getCompatColor(R.color.purple_700)
            fillAlpha = 20
            lineWidth = 1F
            setDrawFilled(false)
            setDrawCircles(false)
        }
}