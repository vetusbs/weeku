package com.weeku.rest

import com.weeku.domain.services.SimpleMenuService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MenuController(private val simpleMenuService: SimpleMenuService) {

    @GetMapping("/menu")
    fun getMenu() = simpleMenuService.generateWeeklyMenu()
}