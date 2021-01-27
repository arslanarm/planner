package me.plony.planner.activators

import com.soywiz.klock.DateTime

public class ScheduleList(
    private val children: List<Schedule>
) : Schedule {
    private var lastTime: DateTime? = null
    private var activeLastTime: List<List<Schedule>>? = null
    override fun active(time: DateTime): Boolean = children
        .groupBy { it::class }
        .values
        .run {
            if (all { it.any { it.active(time) } }.not()) return@run false
            val activatedSchedules = map { it.filter { it.active(time) } }
                .filter { it.isNotEmpty() }
            if (activatedSchedules == activeLastTime) return@run false
            activeLastTime = activatedSchedules
            true
        }
}