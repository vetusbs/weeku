package io.weeku.http

import io.weeku.domain.services.SimpleMenuService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MenuController(
    private val simpleMenuService: SimpleMenuService
) {

    @GetMapping("/menu")
    fun getMenu(model: Model): String {
        model.addAttribute("weeklyMenu", simpleMenuService.generateWeeklyMenu())

        return "menu"
    }
}
