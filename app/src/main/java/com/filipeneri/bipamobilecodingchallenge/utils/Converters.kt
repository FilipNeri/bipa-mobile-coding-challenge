package com.filipeneri.bipamobilecodingchallenge.utils

import java.text.SimpleDateFormat
import java.util.Date

class Converters {
    companion object {
        fun converterToDate(data: Long): Date {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            return dateFormat.parse(data.toString())
        }
    }
}