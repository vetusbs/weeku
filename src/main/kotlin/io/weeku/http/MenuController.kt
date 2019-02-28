package io.weeku.http

import io.weeku.domain.usecase.GenerateWeeklyPlan
import io.weeku.domain.usecase.GenerateWeeklyPlanErrorOutput
import io.weeku.domain.usecase.GenerateWeeklyPlanOkOutput
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute

@Controller
class MenuController(
    private val generateWeeklyPlan: GenerateWeeklyPlan
) {

    @GetMapping("/menu")
    fun getMenu(@ModelAttribute createWeeklyPlan: CreateWeeklyPlanHttpRequest, model: Model): String {

        val weeklyPlanOutput = generateWeeklyPlan.execute(createWeeklyPlan.toGenerateWeeklyPlanInput())

        when (weeklyPlanOutput) {
            is GenerateWeeklyPlanOkOutput -> model.addAttribute("weeklyPlan", weeklyPlanOutput.weeklyPlan)
            is GenerateWeeklyPlanErrorOutput -> model.addAttribute("error", weeklyPlanOutput.error)
        }

        return "menu"
    }
}
