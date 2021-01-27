package me.plony.planner.activators

public class ScheduleBuilder {
    public val schedules: MutableList<Schedule> = mutableListOf()
    public fun build(): Schedule = ScheduleList(schedules)
}