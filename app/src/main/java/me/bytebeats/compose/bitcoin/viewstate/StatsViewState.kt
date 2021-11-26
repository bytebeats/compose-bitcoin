package me.bytebeats.compose.bitcoin.viewstate

import android.content.Context
import android.util.Log
import com.github.mikephil.charting.data.LineDataSet
import me.bytebeats.compose.bitcoin.model.StatsDetail
import me.bytebeats.compose.bitcoin.ui.theme.Purple200
import me.bytebeats.compose.bitcoin.ui.theme.Purple500
import me.bytebeats.compose.bitcoin.ui.theme.Teal200
import me.bytebeats.compose.bitcoin.util.APP_TAG
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
            color = if (context.isInDarkMode()) Purple200.value.toInt() else Purple500.value.toInt()
            highLightColor = Teal200.value.toInt()
            fillAlpha = 200
            lineWidth = 1F
            setDrawFilled(true)
            setDrawCircles(false)
        }
}