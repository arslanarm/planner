@file:Suppress("MemberVisibilityCanBePrivate")

package me.plony.planner.tasks

import com.soywiz.klock.DateTime
import com.soywiz.klock.TimeSpan
import kotlinx.coroutines.*

public class DelayedTask(
    private val delay: TimeSpan,
    task: suspend () -> Unit,
) : Task(task) {
    private var nextTime = DateTime.now() + delay
    override suspend fun loop(): Unit = coroutineScope {
        val now = DateTime.now()
        if (nextTime > now) return@coroutineScope
        val timesToRecover = ((now - nextTime) / delay).toInt()
        nextTime += delay * (timesToRecover + 1)
        launch { task() }
    }
}


