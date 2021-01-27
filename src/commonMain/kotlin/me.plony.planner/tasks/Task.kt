@file:Suppress("MemberVisibilityCanBePrivate")

package me.plony.planner.tasks

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


public abstract class Task(
    protected val task: suspend () -> Unit
) {
    public lateinit var job: Job
    public var isActive: Boolean = false
    public fun CoroutineScope.startTask() : Job {
        require(isActive.not())
        job = launch {
            while (true) {
                try {
                    loop()
                } catch (e: Throwable) {
                    e.printStackTrace()
                }
                delay(1)
            }
        }
        isActive = true
        return job
    }
    public fun stop() {
        require(isActive)
        job.cancel()
        isActive = false
    }
    protected abstract suspend fun loop()
}
