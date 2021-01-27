package me.plony.planner.activators

import com.soywiz.klock.DateTime
import com.soywiz.klock.weekOfYear0

public class DayOfWeekSchedule(dayOfWeek: List<Int>) : DateTimeSchedule<Int>(dayOfWeek) {
    override fun DateTime.comparing(): Int = dayOfWeekInt
}