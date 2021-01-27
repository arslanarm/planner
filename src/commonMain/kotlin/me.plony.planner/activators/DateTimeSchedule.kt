package me.plony.planner.activators

import com.soywiz.klock.DateTime

public abstract class DateTimeSchedule<T>(public var comparing: List<T>) : Schedule {
    protected abstract fun DateTime.comparing(): T
    override fun active(time: DateTime): Boolean = time.comparing() in comparing
    public fun activeComparing(time: DateTime): Pair<Boolean, T> =
        (time.comparing() in comparing) to time.comparing()
}

public inline operator fun <reified T: DateTimeSchedule<R>, reified R> T.plus(other: T): T =
    apply { comparing = comparing + other.comparing }