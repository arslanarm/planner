package me.plony.planner.activators

import com.soywiz.klock.DateTimeRange
import com.soywiz.klock.DayOfWeek
import com.soywiz.klock.Month
import me.plony.planner.utils.DayOfWeekRange
import me.plony.planner.utils.MonthRange

@DslMarker
public annotation class ScheduleDSL

@ScheduleDSL
public fun ScheduleBuilder.second(vararg second: Int) {
    second.map { SecondSchedule(it) }
        .forEach { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.second(seconds: IntRange) {
    seconds.map { SecondSchedule(it) }
        .forEach { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.minute(vararg minute: Int) {
    minute.map { MinuteSchedule(it) }
        .forEach { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.minute(minutes: IntRange) {
    minutes.map { MinuteSchedule(it) }
        .forEach { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.hour(vararg hour: Int) {
    hour.map { HourSchedule(it) }
        .forEach { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.hour(hours: IntRange) {
    hours.map { HourSchedule(it) }
        .forEach { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.dayOfWeek(vararg dayOfWeek: Int) {
    dayOfWeek.map { DayOfWeekSchedule(it) }
        .forEach { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.dayOfWeek(daysOfWeek: IntRange) {
    daysOfWeek.map { DayOfWeekSchedule(it) }
        .forEach { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.dayOfWeek(vararg dayOfWeek: DayOfWeek) {
    dayOfWeek.map { DayOfWeekSchedule(it.index1) }
        .forEach { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.dayOfWeek(range: DayOfWeekRange) {
    range.map {  DayOfWeekSchedule(it.index1) }
        .forEach { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.week(vararg week: Int) {
    week.map { WeekSchedule(it) }
        .forEach { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.week(weeks: IntRange) {
    weeks.map { WeekSchedule(it) }
        .forEach { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.dayOfMonth(vararg dayOfMonth: Int) {
    dayOfMonth.map { DayOfMonthSchedule(it) }
        .forEach { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.dayOfMonth(daysOfMonth: IntRange) {
    daysOfMonth.map { DayOfMonthSchedule(it) }
        .forEach { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.dayOfYear(vararg dayOfYear: Int) {
    dayOfYear.map { DayOfYearSchedule(it) }
        .forEach { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.dayOfYear(daysOfYear: IntRange) {
    daysOfYear.map { DayOfYearSchedule(it) }
        .forEach { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.month(vararg month: Int) {
    month.map { MonthSchedule(it) }
        .forEach { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.month(months: IntRange) {
    months.map { MonthSchedule(it) }
        .forEach { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.month(vararg month: Month) {
    month.map { MonthSchedule(it.index1) }
        .forEach { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.month(range: MonthRange) {
    range.map { MonthSchedule(it.index1) }
        .forEach { schedules.add(it) }
}


@ScheduleDSL
public fun ScheduleBuilder.year(vararg year: Int) {
    year.map { YearSchedule(it) }
        .forEach { schedules.add(it) }
}

@ScheduleDSL
public fun ScheduleBuilder.time(hour: Int, minute: Int = 0, second: Int = 0) {
    hour(hour)
    minute(minute)
    second(second)
}