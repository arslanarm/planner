package me.plony.planner

import kotlinx.coroutines.CoroutineScope
import me.plony.planner.platform.coroutineContextForPlanner
import me.plony.planner.tasks.Task
import kotlin.coroutines.CoroutineContext

public class Planner(
    public val tasks: List<Task>,
    override val coroutineContext: CoroutineContext = coroutineContextForPlanner()
) : CoroutineScope {
    public fun start() {
        tasks.forEach { with(it) { startTask() } }
    }
}