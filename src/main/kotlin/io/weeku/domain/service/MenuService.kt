package io.weeku.domain.service

import io.weeku.domain.model.WeeklyPlan
import org.springframework.stereotype.Component

@Component
interface MenuService {
    fun generateWeeklyMenu(): WeeklyPlan
}
