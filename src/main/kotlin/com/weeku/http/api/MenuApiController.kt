package com.weeku.http.api

import com.weeku.domain.services.SimpleMenuService
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MenuApiController(
        private val simpleMenuService: SimpleMenuService
) {

    @GetMapping("/api/menu")
    fun getMenu(model: Model) =
        simpleMenuService.generateWeeklyMenu()
}
