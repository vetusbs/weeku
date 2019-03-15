package io.weeku.domain.service.csp

import io.weeku.domain.model.DailyMenu
import io.weeku.domain.model.Meal
import io.weeku.domain.model.Tag

data class MaxTagPerMenu(val maxNumber: Int, val tag: Tag) : Constrain {
    override fun check(menus: List<DailyMenu>, meal: Meal): Boolean {
        val allTags = menus.flatMap {
            it.meals
        }.flatMap {
            it.dishes
        }.plus(meal.dishes)
            .flatMap { it.tags }
            .toList()

        return allTags.count { it == tag } <= maxNumber
    }
}
