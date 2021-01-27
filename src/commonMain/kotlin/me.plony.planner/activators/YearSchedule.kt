package me.plony.planner.activators

import com.soywiz.klock.DateTime

public class YearSchedule(year: List<Int>) : DateTimeSchedule<Int, Int>(year) {
    override fun DateTime.comparing(): Int = yearInt
    override fun DateTime.mustBeDifferent(): Int = milliseconds
}