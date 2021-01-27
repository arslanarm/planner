package me.plony.planner.activators

import com.soywiz.klock.DateTime

public class YearSchedule(year: Int) : DateTimeSchedule<Int, Int>(year) {
    override fun DateTime.comparing(): Int = yearInt
}