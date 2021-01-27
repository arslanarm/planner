package me.plony.planner.activators

import com.soywiz.klock.DateTime
import com.soywiz.klock.weekOfYear1

public class WeekSchedule(week: Int) : DateTimeSchedule<Int, Int>(week) {
    override fun DateTime.comparing(): Int = weekOfYear1
}