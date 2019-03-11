package io.weeku.domain.service.csp

import io.weeku.domain.model.DailyMenu
import io.weeku.domain.model.Meal

interface Constrain {
    fun check(menus: List<DailyMenu>, meal: Meal): Boolean
}

class MaxTimesPerDishContraint(val max: Int) : Constrain {
    override fun check(menus: List<DailyMenu>, meal: Meal): Boolean {
        return (menus.flatMap {
            it.meals
        }.flatMap {
            it.dishes
        }.filter { it == meal.dishes.first() }.count() < max)
            &&
            (menus.flatMap {
                it.meals
            }.flatMap {
                it.dishes
            }.filter { it == meal.dishes.last() }.count() < max)
    }
}
