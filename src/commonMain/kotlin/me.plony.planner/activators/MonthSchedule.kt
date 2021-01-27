package me.plony.planner.activators

import com.soywiz.klock.DateTime

public class MonthSchedule(month: Int) : DateTimeSchedule<Int, Int>(month) {
    override fun DateTime.comparing(): Int = month1
}