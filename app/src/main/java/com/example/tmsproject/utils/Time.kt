package com.example.tmsproject.utils

import java.text.SimpleDateFormat
import java.util.*

object Time {

    public fun getCurrentTime(): String {
        val formatter = SimpleDateFormat("hh:mm:ss - yyyy/MM/dd", Locale.getDefault())
        return formatter.format(Calendar.getInstance().time)
    }
}