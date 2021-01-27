package me.plony.planner.activators

import com.soywiz.klock.DateTime

public class HourSchedule(hour: Int) : DateTimeSchedule<Int, Int>(hour) {
    override fun DateTime.comparing(): Int = hours
}