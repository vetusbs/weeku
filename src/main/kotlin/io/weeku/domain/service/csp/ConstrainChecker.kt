package io.weeku.domain.service.csp

import io.weeku.domain.model.DailyMenu
import io.weeku.domain.model.Meal
import io.weeku.domain.model.WeeklyMenu

interface ConstrainChecker {
    fun check(menus: List<DailyMenu>, meal: Meal, constrain: Constrain): Boolean
}
