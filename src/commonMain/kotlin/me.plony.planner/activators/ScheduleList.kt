package me.plony.planner.activators

import com.soywiz.klock.DateTime

public class ScheduleList(
    children: List<DateTimeSchedule<Int>>
) : Schedule {
    private val groupedChildren: Collection<DateTimeSchedule<*>> = children
        .groupBy { it::class }
        .values
        .map { it.drop(1).fold(it.first()) { acc, i -> acc + i } }
    private var lastTime: DateTime? = null

    private fun anyActive(time: DateTime) = groupedChildren.all { it.active(time) }
    private fun activeSchedules(time: DateTime) = groupedChildren
        .map { it.activeComparing(time) }
        .filter { (active, _) -> active }
        .map { (_, comparing) -> comparing }

    override fun active(time: DateTime): Boolean {
        if (anyActive(time).not()) return false
        val activatedSchedules = activeSchedules(time)
        val activatedLastTime = lastTime?.let { lastTime -> activeSchedules(lastTime) }
        if (activatedSchedules == activatedLastTime) return false
        lastTime = time
        return true
    }
}