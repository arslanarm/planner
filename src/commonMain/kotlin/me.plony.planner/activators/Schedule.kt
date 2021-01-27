package me.plony.planner.activators

import com.soywiz.klock.DateTime

public interface Schedule {
    public fun active(time: DateTime): Boolean
}