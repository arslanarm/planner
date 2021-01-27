@file:Suppress("unused")

package me.plony.planner

import com.soywiz.klock.TimeSpan
import me.plony.planner.activators.Schedule
import me.plony.planner.activators.ScheduleBuilder
import me.plony.planner.tasks.DelayedTask
import me.plony.planner.tasks.DelayedTaskBuilder
import me.plony.planner.tasks.ScheduledTask
import me.plony.planner.tasks.ScheduledTaskBuilder

@DslMarker
public annotation class PlannerDSL

@PlannerDSL
public inline fun planner(block: PlannerBuilder.() -> Unit): Planner = PlannerBuilder().apply(block).build()

@PlannerDSL
public inline fun PlannerBuilder.delayedTask(block: DelayedTaskBuilder.() -> Unit): DelayedTask =
    DelayedTaskBuilder()
        .apply(block)
        .build()
        .also { tasks.add(it) }

@PlannerDSL
public fun PlannerBuilder.delayedTask(delay: TimeSpan, block: suspend () -> Unit): DelayedTask =
    DelayedTask(delay, block)
        .also { tasks.add(it) }

@PlannerDSL
public fun PlannerBuilder.scheduledTask(block: ScheduledTaskBuilder.() -> Unit): ScheduledTask =
    ScheduledTaskBuilder()
        .apply(block)
        .build()
        .also { tasks.add(it) }