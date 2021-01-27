package me.plony.planner.activators

public open class ScheduleImpl(
    override val children: List<Schedule> = mutableListOf()
) : Schedule {
    override fun active(): Boolean = children.all { it.active() }
}