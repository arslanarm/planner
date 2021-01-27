package me.plony.planner.tasks

import com.soywiz.klock.DateTime
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import me.plony.planner.activators.Schedule
import me.plony.planner.activators.ScheduleList

public class ScheduledTask(
    private val schedules: List<Schedule>,
    task: suspend () -> Unit
) : Task(task) {
    override suspend fun loop(): Unit = coroutineScope {
        if (schedules.any { it.active(DateTime.now()) }.not()) return@coroutineScope
        launch { task() }
    }
}