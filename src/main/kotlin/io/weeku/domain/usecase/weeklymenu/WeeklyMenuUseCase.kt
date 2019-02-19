package io.weeku.domain.usecase.weeklymenu

import io.weeku.data.model.WeeklyMenu
import org.springframework.stereotype.Component

@Component
interface WeeklyMenuUseCase {
    fun generateWeeklyMenu(): WeeklyMenu
}
