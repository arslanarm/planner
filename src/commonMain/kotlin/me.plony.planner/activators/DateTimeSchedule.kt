package me.plony.planner.activators

import com.soywiz.klock.DateTime

public abstract class DateTimeSchedule<T, R>(comparing: List<T>) : ScheduleImpl() {
    private val sameAndDifferent: MutableMap<T, R> = mutableMapOf<T, R>()
        .apply {
            val now = DateTime.now()
            comparing.forEach {
                put(it, now.mustBeDifferent())
            }
        }
    protected abstract fun DateTime.comparing(): T
    protected abstract fun DateTime.mustBeDifferent(): R
    override fun active(): Boolean {
        val now = DateTime.now()
        val childrenAreActive = super.active()
        val comparing = now.comparing()
        val mustBeDifferent = sameAndDifferent[comparing] ?: return false
        val newDifferent = now.mustBeDifferent()
        val different = mustBeDifferent != newDifferent
        if (different) sameAndDifferent[comparing] = newDifferent
        return childrenAreActive and different
    }
}