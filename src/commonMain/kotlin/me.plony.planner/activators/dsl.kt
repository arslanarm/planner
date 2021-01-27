package me.plony.planner.activators

import com.soywiz.klock.DayOfWeek
import com.soywiz.klock.Month
import me.plony.planner.utils.DayOfWeekRange
import me.plony.planner.utils.MonthRange

@DslMarker
public annotation class ScheduleDSL

@ScheduleDSL
public fun ScheduleBuilder.second(vararg second: Int) {
    SecondSchedule(second.toList())
        .also { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.second(seconds: IntRange) {
    SecondSchedule(seconds.toList())
        .also { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.minute(vararg minute: Int) {
    MinuteSchedule(minute.toList())
        .also { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.minute(minutes: IntRange) {
    MinuteSchedule(minutes.toList())
        .also { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.hour(vararg hour: Int) {
    HourSchedule(hour.toList())
        .also { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.hour(hours: IntRange) {
    HourSchedule(hours.toList())
        .also { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.dayOfWeek(vararg daysOfWeek: Int) {
    DayOfWeekSchedule(daysOfWeek.toList())
        .also { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.dayOfWeek(daysOfWeek: IntRange) {
    DayOfWeekSchedule(daysOfWeek.toList())
        .also { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.dayOfWeek(vararg dayOfWeek: DayOfWeek) {
    DayOfWeekSchedule(dayOfWeek.map { it.index1 })
        .also { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.dayOfWeek(range: DayOfWeekRange) {
    DayOfWeekSchedule(range.map { it.index1 })
        .also { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.week(vararg week: Int) {
    WeekSchedule(week.toList())
        .also { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.week(weeks: IntRange) {
     WeekSchedule(weeks.toList())
        .also { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.dayOfMonth(vararg dayOfMonth: Int) {
    DayOfMonthSchedule(dayOfMonth.toList())
        .also { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.dayOfMonth(daysOfMonth: IntRange) {
    DayOfMonthSchedule(daysOfMonth.toList())
        .also { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.dayOfYear(vararg dayOfYear: Int) {
     DayOfYearSchedule(dayOfYear.toList())
        .also { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.dayOfYear(daysOfYear: IntRange) {
    DayOfYearSchedule(daysOfYear.toList())
        .also { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.month(vararg month: Int) {
    MonthSchedule(month.toList())
        .also { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.month(months: IntRange) {
    MonthSchedule(months.toList())
        .also { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.month(vararg month: Month) {
    MonthSchedule(month.map { it.index1 })
        .also { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.month(range: MonthRange) {
    MonthSchedule(range.map { it.index1 })
        .also { schedules.add(it) }
}


@ScheduleDSL
public fun ScheduleBuilder.year(vararg year: Int) {
  YearSchedule(year.toList())
        .also { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.time(hour: Int, minute: Int = 0, second: Int = 0) {
    hour(hour)
    minute(minute)
    second(second)
}