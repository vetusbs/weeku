package com.weeku.domain.services

import com.weeku.domain.services.objects.WeeklyMenu
import org.springframework.stereotype.Component

@Component
interface MenuService {
    fun generateWeeklyMenu(): WeeklyMenu
}