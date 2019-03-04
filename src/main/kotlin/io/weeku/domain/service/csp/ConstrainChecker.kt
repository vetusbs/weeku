package io.weeku.domain.service.csp

import io.weeku.domain.model.Dish
import io.weeku.domain.model.WeeklyMenu

interface ConstrainChecker {
    fun check(weeklyMenu: WeeklyMenu, dish: Dish, constrain: Constrain): Boolean
}
