package me.plony.planner.activators

import com.soywiz.klock.DateTime

public class YearSchedule(years: List<Int>) : DateTimeSchedule<Int>(years) {
    override fun DateTime.comparing(): Int = yearInt
}