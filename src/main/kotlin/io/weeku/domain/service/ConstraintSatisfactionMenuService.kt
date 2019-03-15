package io.weeku.domain.service

import io.weeku.domain.model.DailyMenu
import io.weeku.domain.model.Dish
import io.weeku.domain.model.Meal
import io.weeku.domain.model.TwoDishMeal
import io.weeku.domain.model.WeeklyMenu
import io.weeku.domain.service.csp.Constrain
import org.springframework.stereotype.Component

@Component
class ConstraintSatisfactionMenuService(
    val dishRepository: DishRepository
) : MenuService {
    override fun generateWeeklyMenu(numberOfDays: Int, userConstraints: List<Constrain>): WeeklyMenu {
        val fetchAllDishes = dishRepository.fetchAllDishes()

        val listOfDailyMenus = mutableListOf<DailyMenu>()

        while (listOfDailyMenus.size < numberOfDays) {
            val generateDailyMenu = generateDailyMenu(listOfDailyMenus, fetchAllDishes, 0, userConstraints)
            listOfDailyMenus.add(generateDailyMenu)
        }
        return WeeklyMenu(listOfDailyMenus)
    }

    internal fun generateDailyMenu(
        listOfDailyMenus: MutableList<DailyMenu>,
        listOfPossibleDishes: List<Dish>,
        index: Int,
        userConstraints: List<Constrain>
    ): DailyMenu {

        val meal1 = generateMeal(listOfPossibleDishes.shuffled(), 0, 0, listOfDailyMenus, userConstraints)
        val tempMeal = DailyMenu(listOf(meal1))
        listOfDailyMenus.add(tempMeal)
        val meal2 = generateMeal(listOfPossibleDishes.shuffled(), 0, 0, listOfDailyMenus, userConstraints)
        listOfDailyMenus.remove(tempMeal)
        return DailyMenu(listOf(meal1, meal2))
    }

    internal fun generateMeal(
        listOfPossibleDishes: List<Dish>,
        index1: Int,
        index2: Int,
        menus: List<DailyMenu>,
        userConstraints: List<Constrain>
    ): Meal {
        val dish1 = listOfPossibleDishes[index1]
        val dish2 = listOfPossibleDishes[index2]
        if (validate(dish1, dish2, menus, userConstraints)) {
            return TwoDishMeal(dish1, dish2)
        } else if (index1 + 1 < listOfPossibleDishes.size) {
            return generateMeal(listOfPossibleDishes, index1 + 1, index2, menus, userConstraints)
        } else if (index2 + 1 < listOfPossibleDishes.size) {
            return generateMeal(listOfPossibleDishes, 0, index2 + 1, menus, userConstraints)
        } else {
            throw RuntimeException("The constraints cannot be reached")
        }
    }

    internal fun validate(dish1: Dish, dish2: Dish, menus: List<DailyMenu>, userConstraints: List<Constrain>): Boolean {
        return userConstraints.map {
            it.check(menus, TwoDishMeal(dish1, dish2))
        }.count { !it } == 0
    }
}
