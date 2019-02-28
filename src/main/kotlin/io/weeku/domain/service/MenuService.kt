package io.weeku.domain.service

import io.weeku.domain.model.WeeklyMenu
import org.springframework.stereotype.Component

@Component
interface MenuService {
    fun generateWeeklyMenu(numberOfDays: Int): WeeklyMenu
}
