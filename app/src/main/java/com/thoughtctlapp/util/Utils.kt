package com.thoughtctlapp.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date

object Utils {

    @SuppressLint("SimpleDateFormat")
    public fun getDateTime(dateTime: Int): String {
        try {
            val sdf = SimpleDateFormat("dd/MM/yyyy hh:mm a")
            val netDate = Date(dateTime.toLong())
            return sdf.format(netDate)
        } catch (e: Exception) {
            return ""
        }
    }

}