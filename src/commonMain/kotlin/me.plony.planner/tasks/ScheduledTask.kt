package me.plony.planner.tasks

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import me.plony.planner.activators.Schedule

public class ScheduledTask(
    private val schedule: Schedule,
    task: suspend () -> Unit
) : Task(task) {
    override suspend fun loop(): Unit = coroutineScope {
        if (schedule.active().not()) return@coroutineScope
        launch { task() }
    }
}