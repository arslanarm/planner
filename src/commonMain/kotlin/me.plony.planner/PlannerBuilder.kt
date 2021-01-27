package me.plony.planner

import me.plony.planner.tasks.Task

public class PlannerBuilder {
    public val tasks: MutableList<Task> = mutableListOf()
    public fun build(): Planner = Planner(tasks)
}