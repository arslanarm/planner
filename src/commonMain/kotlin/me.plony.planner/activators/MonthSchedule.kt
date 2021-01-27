package me.plony.planner.activators

import com.soywiz.klock.DateTime

public class MonthSchedule(month: List<Int>) : DateTimeSchedule<Int>(month) {
    override fun DateTime.comparing(): Int = month1
}