package io.weeku.domain.service.csp

import io.weeku.domain.model.DailyMenu
import io.weeku.domain.model.Meal

class MaxTimesPerDishContraint(val max: Int) : Constrain {
    override fun check(menus: List<DailyMenu>, meal: Meal): Boolean {
        val allDishes = menus.flatMap {
            it.meals
        }.flatMap {
            it.dishes
        }.plus(meal.dishes)
            .toList()

        return allDishes.groupBy { it.name }.count { it.value.size > max } == 0
    }
}
