import com.soywiz.klock.seconds
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import me.plony.planner.activators.hour
import me.plony.planner.activators.minute
import me.plony.planner.activators.second
import me.plony.planner.planner
import me.plony.planner.scheduledTask
import me.plony.planner.tasks.schedule
import java.time.LocalDateTime
import java.util.concurrent.Executors

suspend fun main() {
    planner {
        scheduledTask {
            schedule {
                second(0..59)
            }

            action {
                println("Per second ${LocalDateTime.now()}")
            }
        }

        scheduledTask {
            schedule {
                second(0, 30)
            }
            action {
                println("Per half minute ${LocalDateTime.now()}")
            }
        }
    }.run {
        Executors.newSingleThreadExecutor().asCoroutineDispatcher()
        start()
        delay(2.seconds.milliseconds.toLong())
        stop()
        start()
        delay(2.seconds.milliseconds.toLong())
        stop()
    }
}
