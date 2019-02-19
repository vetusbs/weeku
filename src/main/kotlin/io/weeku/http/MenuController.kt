package io.weeku.http

import io.weeku.domain.service.MenuService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MenuController(
    private val menuService: MenuService
) {

    @GetMapping("/menu")
    fun getMenu(model: Model): String {
        model.addAttribute("weeklyMenu", menuService.generateWeeklyMenu())

        return "menu"
    }
}
