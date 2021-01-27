package me.plony.planner.activators

import com.soywiz.klock.Date
import com.soywiz.klock.DateTime

public class ScheduleList(
    children: List<Schedule>
) : Schedule {
    public val groupedChildren: Collection<List<Schedule>> = children
        .groupBy { it::class }
        .values
    private var lastTime: DateTime? = null

    private fun anyActive(time: DateTime) = groupedChildren.all { it.any { it.active(time) } }
    private fun activeSchedules(time: DateTime) = groupedChildren
        .map { it.filter { it.active(time) } }
        .filter { it.isNotEmpty() }
    override fun active(time: DateTime): Boolean {
            if (anyActive(time).not()) return false
            val activatedSchedules = activeSchedules(time)
            val activatedLastTime = lastTime?.let { lastTime -> activeSchedules(lastTime) }
            if (activatedSchedules == activatedLastTime) return false
            lastTime = time
            return true
        }
}