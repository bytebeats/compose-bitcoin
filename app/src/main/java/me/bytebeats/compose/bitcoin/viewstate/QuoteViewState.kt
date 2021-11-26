package me.bytebeats.compose.bitcoin.viewstate

import android.content.Context
import android.graphics.drawable.Drawable
import com.github.mikephil.charting.data.LineDataSet
import me.bytebeats.compose.bitcoin.R
import me.bytebeats.compose.bitcoin.enums.QuotePriceChangeStatus
import me.bytebeats.compose.bitcoin.model.QuoteDetail
import me.bytebeats.compose.bitcoin.util.ktx.getCompatColor
import me.bytebeats.compose.bitcoin.util.ktx.getCompatDrawable

/**
 * Created by bytebeats on 2021/11/24 : 14:19
 * E-mail: happychinapc@gmail.com
 * Quote: Peasant. Educated. Worker
 */
class QuoteViewState(val quoteDetail: QuoteDetail) {
    fun lineDataSet(context: Context): LineDataSet =
        LineDataSet(quoteDetail.chartEntries, "quote_price").apply {
            mode = LineDataSet.Mode.CUBIC_BEZIER
            color = getColor(context)
            highLightColor = getColor(context)
            fillDrawable = getBackground(context)
            lineWidth = 2F
            setDrawFilled(true)
            setDrawCircles(false)
        }

    fun isChangeStatusPositive(): Boolean =
        quoteDetail.changeStatus == QuotePriceChangeStatus.POSITIVE

    private fun getColor(context: Context): Int =
        context.getCompatColor(
            if (quoteDetail.changeStatus == QuotePriceChangeStatus.POSITIVE)
                R.color.green_500 else R.color.red_500
        )

    private fun getBackground(context: Context): Drawable? =
        context.getCompatDrawable(
            if (quoteDetail.changeStatus == QuotePriceChangeStatus.POSITIVE)
                R.drawable.background_positive_chart
            else R.drawable.background_negative_chart
        )
}