package me.plony.planner

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import me.plony.planner.platform.coroutineContextForPlanner
import me.plony.planner.tasks.Task
import kotlin.coroutines.CoroutineContext

public class Planner(
    public val tasks: List<Task>,
    override val coroutineContext: CoroutineContext = coroutineContextForPlanner() + Job()
) : CoroutineScope {
    public fun start() {
        tasks.forEach { with(it) { startTask() } }
    }
    public fun stop() {
        tasks.forEach { it.stop() }
    }
}