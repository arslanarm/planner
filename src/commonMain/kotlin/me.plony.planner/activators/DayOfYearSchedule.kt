package me.plony.planner.activators

import com.soywiz.klock.DateTime

public class DayOfYearSchedule(dayOfYear: List<Int>) : DateTimeSchedule<Int>(dayOfYear) {
    override fun DateTime.comparing(): Int = dayOfYear
}