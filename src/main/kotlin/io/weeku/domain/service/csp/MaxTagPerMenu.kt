package io.weeku.domain.service.csp

import io.weeku.domain.model.DailyMenu
import io.weeku.domain.model.Meal
import io.weeku.domain.model.Tag

data class MaxTagPerMenu(val maxNumber: Int, val tag: Tag) : Constrain {
    override fun check(menus: List<DailyMenu>, meal: Meal): Boolean {
        return menus.flatMap {
            it.meals
        }.flatMap {
            it.dishes
        }.toMutableList()
            .apply { this.addAll(meal.dishes) }
            .flatMap { it.tags }
            .count { it == tag } < maxNumber

    }
}
