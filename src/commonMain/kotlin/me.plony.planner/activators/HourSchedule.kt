package me.plony.planner.activators

import com.soywiz.klock.DateTime

public class HourSchedule(hour: List<Int>) : DateTimeSchedule<Int>(hour) {
    override fun DateTime.comparing(): Int = hours
}