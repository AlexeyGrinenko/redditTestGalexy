package s.com.reddittestgalexy.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.util.Log
import android.view.View
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import s.com.reddittestgalexy.BuildConfig
import s.com.reddittestgalexy.R

fun log(message: String, key: String = "Log_Key_Debug") {
    if (BuildConfig.DEBUG) Log.d(key, message)
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun getBitmapFromVectorDrawable(@DrawableRes drawableId: Int, context: Context): Bitmap? {
    val drawable = AppCompatResources.getDrawable(context, drawableId) ?: return null
    val bitmap = Bitmap.createBitmap(
        drawable.intrinsicWidth,
        drawable.intrinsicHeight, Bitmap.Config.ARGB_8888
    )
    val canvas = Canvas(bitmap)
    drawable.setBounds(0, 0, canvas.width, canvas.height)
    drawable.draw(canvas)
    return bitmap
}

fun getTimeDiffMessage(timeForDiff: Long, context: Context): String {
    val diff = System.currentTimeMillis()/1000 - timeForDiff
    val minutes = diff  / 60
    val hours = minutes / 60
    val days = hours / 24
    return when {
        (days > 1) -> context.getString(R.string.days_ago,days)
        (hours > 1) -> context.getString(R.string.hours_ago, hours)
        else -> context.getString(R.string.minutes_ago, minutes)
    }
}
