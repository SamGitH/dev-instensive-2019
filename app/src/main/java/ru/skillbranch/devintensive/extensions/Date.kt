package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*
import javax.net.ssl.HostnameVerifier

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern:String="HH:mm:ss dd.MM.yy"):String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value:Int, units: TimeUnits = TimeUnits.SECOND) :Date{
    var time = this.time

    time+=when(units){
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(date:Date = Date()):String{
    //TODO()
    var unit = String()
    var visitTime = this.time - date.time
    var visitDate = Date(visitTime)
    if(visitTime < HOUR) {
        unit = "минут"
        return "${visitDate.minutes} $unit"
    }
    else if(visitTime < DAY) {
        unit = "часов"
        return "${visitDate.hours} $unit"
    }
    else {
        unit = "дней"
        return "${visitDate.day} $unit"
    }
    return "${visitDate.format()}"
//    val visitTime = Date(this.time - date.time)
//    visitTime.
//    return "$visitTime"
}

enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY
}