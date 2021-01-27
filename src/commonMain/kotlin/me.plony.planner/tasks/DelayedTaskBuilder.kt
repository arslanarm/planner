@file:Suppress("MemberVisibilityCanBePrivate")

package me.plony.planner.tasks

import com.soywiz.klock.TimeSpan
import kotlin.properties.Delegates

public class DelayedTaskBuilder {
    public var delay: TimeSpan by Delegates.notNull()
    private var task: suspend () -> Unit = {}
    @ActionDSL
    public fun action(block: suspend () -> Unit) {
        task = block
    }

    public fun build(): DelayedTask {
        return DelayedTask(delay, task)
    }
}