package io.weeku.http

import io.weeku.domain.usecase.GenerateWeeklyPlan
import io.weeku.domain.usecase.GenerateWeeklyPlanInput
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class MenuController(
    private val generateWeeklyPlan: GenerateWeeklyPlan
) {

    @GetMapping("/menu")
    fun getMenu(@RequestParam("numberOfDays", required = false) numberOfDays: Int?, model: Model): String {
        numberOfDays?.also {
            model.addAttribute("weeklyPlan", generateWeeklyPlan
                .execute(
                    GenerateWeeklyPlanInput(it)
                ).weeklyPlan
            )
        }
        return "menu"
    }
}
