package me.plony.planner.utils

import com.soywiz.klock.DayOfWeek


public operator fun ClosedRange<DayOfWeek>.iterator(): Iterator<DayOfWeek> = object : Iterator<DayOfWeek> {
    private var current = start
    override fun hasNext(): Boolean = current.next != endInclusive.next
    override fun next(): DayOfWeek = current.next
}

public inline fun <reified R> ClosedRange<DayOfWeek>.map(block: (DayOfWeek) -> R): MutableList<R> {
    val result = mutableListOf<R>()
    for (i in this) {
        result.add(block(i))
    }
    return result
}