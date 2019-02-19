package io.weeku.domain.services

import io.weeku.domain.services.objects.WeeklyMenu
import org.springframework.stereotype.Component

@Component
interface MenuService {
    fun generateWeeklyMenu(): WeeklyMenu
}
