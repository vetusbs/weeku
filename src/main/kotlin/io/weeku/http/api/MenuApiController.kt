package io.weeku.http.api

import io.weeku.domain.model.WeeklyPlan
import io.weeku.domain.service.MenuService
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MenuApiController(
    private val menuService: MenuService
) {

    @GetMapping("/api/menu")
    fun getMenu(model: Model): WeeklyPlan {
        val generateWeeklyMenu = menuService.generateWeeklyMenu()
        return generateWeeklyMenu
    }
}
