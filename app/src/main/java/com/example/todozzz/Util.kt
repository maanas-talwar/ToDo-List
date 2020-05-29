package com.example.todozzz

import android.content.res.Resources
import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import com.example.todozzz.database.MasterListEntity

/**
 * These functions create a formatted string that can be set in a TextView.
 */

fun formatTasks(tasks: List<MasterListEntity>, resources: Resources): Spanned {
    val sb = StringBuilder()
    sb.apply {
//        append(resources.getString(R.string.title))
        tasks.forEach {
            append("<br>")
            append(resources.getString(R.string.display_task_name))
            append("\t${it.taskInfo}<br>")
        }
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}
