package me.plony.planner.tasks

import me.plony.planner.activators.Schedule
import me.plony.planner.activators.ScheduleBuilder
import me.plony.planner.activators.ScheduleDSL

@DslMarker
public annotation class ActionDSL

@ScheduleDSL
public inline fun ScheduledTaskBuilder.schedule(block: ScheduleBuilder.() -> Unit): Schedule =
    ScheduleBuilder()
        .apply(block)
        .build()
        .also { schedules += it }