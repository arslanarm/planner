@file:Suppress("SuspendFunctionOnCoroutineScope")

import com.soywiz.klock.DayOfWeek
import com.soywiz.klock.seconds
import me.plony.planner.activators.dayOfWeek
import me.plony.planner.activators.hour
import me.plony.planner.activators.second
import me.plony.planner.delayedTask
import me.plony.planner.planner
import me.plony.planner.scheduledTask
import me.plony.planner.tasks.schedule
import me.plony.planner.utils.rangeTo
import java.time.LocalDateTime

public fun main() {
    planner {
        scheduledTask {
            schedule {
                second(1..20)
                dayOfWeek(DayOfWeek.Monday..DayOfWeek.Friday)
            }
            schedule {
                second(59)
            }
            action {
                println("Hello ${LocalDateTime.now()}")
            }
        }
        delayedTask {
            delay = 10.seconds
            action {
                println("Another hello ${LocalDateTime.now()}")
            }
        }
    }.start()
}