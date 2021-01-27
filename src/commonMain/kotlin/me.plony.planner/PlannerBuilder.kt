package me.plony.planner

import me.plony.planner.platform.coroutineContextForPlanner
import me.plony.planner.tasks.Task
import kotlin.coroutines.CoroutineContext

public class PlannerBuilder {
    public val tasks: MutableList<Task> = mutableListOf()
    public var coroutineContext: CoroutineContext = coroutineContextForPlanner()
    public fun build(): Planner = Planner(tasks, coroutineContext)
}