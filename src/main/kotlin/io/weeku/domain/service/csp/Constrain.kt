package io.weeku.domain.service.csp

import io.weeku.domain.model.DailyMenu
import io.weeku.domain.model.Meal

interface Constrain {
    fun check(menus: List<DailyMenu>, meal: Meal): Boolean
}
