package io.weeku.http.api

import io.weeku.domain.model.WeeklyPlan
import io.weeku.domain.usecase.GenerateWeeklyPlan
import io.weeku.domain.usecase.GenerateWeeklyPlanInput
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MenuApiController(
    private val generateWeeklyPlan: GenerateWeeklyPlan
) {

    @GetMapping("/api/menu")
    fun getMenu(model: Model): WeeklyPlan {
        return generateWeeklyPlan.execute(GenerateWeeklyPlanInput(5)).weeklyPlan
    }
}
