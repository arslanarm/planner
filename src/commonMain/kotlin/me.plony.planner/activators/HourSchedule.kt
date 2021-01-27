package me.plony.planner.activators

import com.soywiz.klock.DateTime

public class HourSchedule(hour: List<Int>) : DateTimeSchedule<Int, Int>(hour) {
    override fun DateTime.comparing(): Int = hours
    override fun DateTime.mustBeDifferent(): Int = dayOfWeekInt
}