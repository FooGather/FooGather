package io.jspiner.foogather.util

import java.text.SimpleDateFormat
import java.util.*

fun Date.format(format: String): String {
    return SimpleDateFormat(format, Locale.KOREA).format(this)
}
