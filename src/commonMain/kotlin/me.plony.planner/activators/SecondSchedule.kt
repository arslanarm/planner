package me.plony.planner.activators

import com.soywiz.klock.DateTime

public class SecondSchedule(second: List<Int>) : DateTimeSchedule<Int>(second) {
    override fun DateTime.comparing(): Int = seconds
}