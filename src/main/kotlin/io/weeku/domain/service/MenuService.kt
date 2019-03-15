package io.weeku.domain.service

import io.weeku.domain.model.WeeklyMenu
import io.weeku.domain.service.csp.Constrain
import org.springframework.stereotype.Component

@Component
interface MenuService {
    fun generateWeeklyMenu(numberOfDays: Int, userContraints: List<Constrain>): WeeklyMenu
}
