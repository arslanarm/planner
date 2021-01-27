package me.plony.planner.activators

public class ScheduleBuilder {
    public val schedules: MutableList<DateTimeSchedule<Int>> = mutableListOf()
    public fun build(): Schedule = ScheduleList(schedules)
}