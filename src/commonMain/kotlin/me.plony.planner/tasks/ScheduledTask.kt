package me.plony.planner.tasks

import com.soywiz.klock.DateTime
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import me.plony.planner.activators.Schedule

public class ScheduledTask(
    private val schedules: List<Schedule>,
    task: suspend () -> Unit
) : Task(task) {
    override suspend fun loop(): Unit = coroutineScope {
        val now = DateTime.now()
        repeat(schedules.count { it.active(now) }) { launch { task() } }
    }
}