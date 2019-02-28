package io.weeku.http.api

import io.weeku.domain.usecase.GenerateWeeklyPlan
import io.weeku.domain.usecase.GenerateWeeklyPlanErrorOutput
import io.weeku.domain.usecase.GenerateWeeklyPlanOkOutput
import io.weeku.http.CreateWeeklyPlanHttpRequest
import io.weeku.http.CreateWeeklyPlanHttpResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RestController

@RestController
class MenuApiController(
    private val generateWeeklyPlan: GenerateWeeklyPlan
) {

    @GetMapping("/api/menu")
    fun getMenu(@ModelAttribute createWeeklyPlan: CreateWeeklyPlanHttpRequest): ResponseEntity<*> {
        val weeklyPlanOutput = generateWeeklyPlan.execute(createWeeklyPlan.toGenerateWeeklyPlanInput())

        return when (weeklyPlanOutput) {
            is GenerateWeeklyPlanOkOutput ->
                ResponseEntity.ok(CreateWeeklyPlanHttpResponse(weeklyPlanOutput.weeklyPlan))
            is GenerateWeeklyPlanErrorOutput -> ResponseEntity.badRequest().body(weeklyPlanOutput.error)
        }
    }
}
