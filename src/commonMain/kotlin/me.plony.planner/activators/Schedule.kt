package me.plony.planner.activators

public interface Schedule {
    public val children: List<Schedule>
    public fun active(): Boolean
}