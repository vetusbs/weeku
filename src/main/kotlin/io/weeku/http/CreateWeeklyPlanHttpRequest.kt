package io.weeku.http

import io.weeku.domain.usecase.GenerateWeeklyPlanInput

private const val DEFAULT_DAYS = 5

data class CreateWeeklyPlanHttpRequest(val numberOfDays: Int = DEFAULT_DAYS) {
    fun toGenerateWeeklyPlanInput() = GenerateWeeklyPlanInput(numberOfDays)
}
