package me.plony.planner.activators

import com.soywiz.klock.DateTime

public class DayOfYearSchedule(dayOfYear: List<Int>) : DateTimeSchedule<Int, Int>(dayOfYear) {
    override fun DateTime.comparing(): Int = dayOfYear
    override fun DateTime.mustBeDifferent(): Int = yearInt
}