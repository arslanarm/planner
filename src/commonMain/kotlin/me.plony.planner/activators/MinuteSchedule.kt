@file:Suppress("LocalVariableName")

package me.plony.planner.activators

import com.soywiz.klock.DateTime

public class MinuteSchedule(minute: Int) : DateTimeSchedule<Int, Int>(minute) {
    override fun DateTime.comparing(): Int = minutes
}