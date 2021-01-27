package me.plony.planner.utils

import com.soywiz.klock.DayOfWeek
import com.soywiz.klock.Month

public class DayOfWeekRange(
    override val start: DayOfWeek,
    override val endInclusive: DayOfWeek
) : ClosedRange<DayOfWeek>, Iterable<DayOfWeek> {
    public fun toList(): List<DayOfWeek> =
        mutableListOf<DayOfWeek>().apply {
            var current = start
            while (current != endInclusive.next) {
                add(current)
                current = current.next
            }
        }
    public override operator fun iterator(): Iterator<DayOfWeek> = toList().iterator()
}

public class MonthRange(
    override val start: Month,
    override val endInclusive: Month
) : ClosedRange<Month>, Iterable<Month> {
    public fun toList(): List<Month> =
        mutableListOf<Month>().apply {
            var current = start
            while (current != endInclusive.next) {
                add(current)
                current = current.next
            }
        }
    public override operator fun iterator(): Iterator<Month> = toList().iterator()
}

public operator fun DayOfWeek.rangeTo(other: DayOfWeek): DayOfWeekRange =
    DayOfWeekRange(this, other)

public operator fun Month.rangeTo(other: Month): MonthRange =
    MonthRange(this, other)