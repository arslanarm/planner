package me.plony.planner.activators

import com.soywiz.klock.DateTime
import com.soywiz.klock.weekOfYear1

public class WeekSchedule(week: List<Int>) : DateTimeSchedule<Int>(week) {
    override fun DateTime.comparing(): Int = weekOfYear1
}