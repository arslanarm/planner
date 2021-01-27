package me.plony.planner.activators

import com.soywiz.klock.DateTime

public class SecondSchedule(second: Int) : DateTimeSchedule<Int, Int>(second) {
    override fun DateTime.comparing(): Int = seconds
}