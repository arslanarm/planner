package me.plony.planner.tasks

import me.plony.planner.activators.Schedule

public class ScheduledTaskBuilder {
    public lateinit var schedule: Schedule
    private lateinit var task: suspend () -> Unit
    public fun action(task: suspend () -> Unit) {
        this.task = task
    }
    public fun build(): ScheduledTask = ScheduledTask(schedule, task)
}