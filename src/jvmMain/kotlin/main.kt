import com.soywiz.klock.DayOfWeek
import com.soywiz.klock.seconds
import me.plony.planner.activators.dayOfWeek
import me.plony.planner.activators.second
import me.plony.planner.delayedTask
import me.plony.planner.planner
import me.plony.planner.schedule
import me.plony.planner.scheduledTask
import java.time.LocalDateTime

public fun main() {
    planner {
        scheduledTask {
            schedule {
                second(0, 1, 2, 3, 50)
                dayOfWeek(DayOfWeek.Monday..DayOfWeek.Friday)
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