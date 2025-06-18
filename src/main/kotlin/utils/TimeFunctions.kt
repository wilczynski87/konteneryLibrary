package com.kontenery.library.utils

import kotlinx.datetime.*

fun LocalDate.Companion.now(): LocalDate = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date

fun LocalDate.Companion.startOfCurrentMonth(period: LocalDate? = null): LocalDate {
    val currentDate:LocalDate = period ?: Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
    return LocalDate(currentDate.year, currentDate.monthNumber, 1)
}

fun LocalDate.Companion.endOfCurrentMonth(period: LocalDate? = null): LocalDate {
    val startOfCurrentMonth:LocalDate = if(period == null) LocalDate.Companion.startOfCurrentMonth() else LocalDate.Companion.startOfCurrentMonth(period)
    return startOfCurrentMonth.plus(1, DateTimeUnit.MONTH).minus(1, DateTimeUnit.DAY)
}

fun LocalDate.Companion.startOfCurrentYear(period: LocalDate? = null): LocalDate {
    val currentDate: LocalDate = period ?: Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
    return parse("${currentDate.year}-01-01")
}

fun LocalDate.Companion.endOfCurrentYear(period: LocalDate? = null): LocalDate {
    val endOfCurrentMonth: LocalDate = if(period == null) LocalDate.Companion.endOfCurrentMonth() else LocalDate.Companion.endOfCurrentMonth(period)
    return parse("${endOfCurrentMonth.year}-12-${endOfCurrentMonth.dayOfMonth}")
}