package me.plony.planner.activators

import com.soywiz.klock.DateTime

public class DayOfMonthSchedule(dayOfMonth: List<Int>) : DateTimeSchedule<Int, Int>(dayOfMonth) {
    override fun DateTime.comparing(): Int = dayOfMonth
    override fun DateTime.mustBeDifferent(): Int = month1
}