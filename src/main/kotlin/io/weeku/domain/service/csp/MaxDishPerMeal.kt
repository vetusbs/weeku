package io.weeku.domain.service.csp

import io.weeku.domain.model.DailyMenu
import io.weeku.domain.model.Meal

data class MaxDishPerMeal(val maxNumber: Int) : Constrain {
    override fun check(menus: List<DailyMenu>, meal: Meal): Boolean {
        return meal.dishes
            .groupBy { it }
            .count { it.value.size > maxNumber } == 0
    }
}
