package me.plony.planner.tasks

import me.plony.planner.activators.Schedule

public class ScheduledTaskBuilder {
    public val schedules: MutableList<Schedule> = mutableListOf()
    private lateinit var task: suspend () -> Unit
    @ActionDSL
    public fun action(task: suspend () -> Unit) {
        this.task = task
    }
    public fun build(): ScheduledTask = ScheduledTask(schedules, task)
}