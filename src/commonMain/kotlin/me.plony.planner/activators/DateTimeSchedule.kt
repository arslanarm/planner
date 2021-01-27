package me.plony.planner.activators

import com.soywiz.klock.DateTime

public abstract class DateTimeSchedule<T, R>(public val comparing: T) : Schedule {
    protected abstract fun DateTime.comparing(): T
    override fun active(time: DateTime): Boolean = time.comparing() == comparing
}