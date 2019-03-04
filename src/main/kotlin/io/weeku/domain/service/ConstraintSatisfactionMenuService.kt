package io.weeku.domain.service

import io.weeku.domain.model.DailyMenu
import io.weeku.domain.model.Dish
import io.weeku.domain.model.Meal
import io.weeku.domain.model.TwoDishMeal
import io.weeku.domain.model.WeeklyMenu
import io.weeku.domain.service.csp.ConstrainChecker
import org.springframework.stereotype.Component
import java.lang.RuntimeException

@Component
class ConstraintSatisfactionMenuService(
    val dishRepository: DishRepository,
    val contrainCheckers: List<ConstrainChecker>
) : MenuService {
    override fun generateWeeklyMenu(numberOfDays: Int): WeeklyMenu {
        val fetchAllDishes = dishRepository.fetchAllDishes()

        val listOfDailyMenus = mutableListOf<DailyMenu>()

        while (listOfDailyMenus.size < numberOfDays) {
            val generateDailyMenu = generateDailyMenu(listOfDailyMenus, fetchAllDishes, 0)
            listOfDailyMenus.add(generateDailyMenu)
        }
        return WeeklyMenu(listOfDailyMenus)
    }

    internal fun generateDailyMenu(
        listOfDailyMenus: List<DailyMenu>,
        listOfPossibleDishes: List<Dish>,
        index: Int): DailyMenu {

        val meal1 = generateMeal(listOfPossibleDishes, 0, 0, listOfDailyMenus, listOfDailyMenus.flatMap { it.meals })
        val toMutableList = listOfDailyMenus.flatMap { it.meals }.toMutableList()
        toMutableList.add(meal1)
        val meal2 = generateMeal(listOfPossibleDishes, 0, 0, listOfDailyMenus, toMutableList)

        return DailyMenu(listOf(meal1, meal2))
    }

    internal fun generateMeal(
        listOfPossibleDishes: List<Dish>,
        index1: Int,
        index2: Int,
        menus: List<DailyMenu>,
        meals: List<Meal>
    ): Meal {
        val dish1 = listOfPossibleDishes[index1]
        val dish2 = listOfPossibleDishes[index2]
        if (validate(dish1, dish2, menus, meals)) {
            return TwoDishMeal(dish1, dish2)
        } else if (index1 + 1 < listOfPossibleDishes.size) {
            return generateMeal(listOfPossibleDishes, index1 + 1, 0, menus, meals)
        } else if (index2 + 1 < listOfPossibleDishes.size) {
            return generateMeal(listOfPossibleDishes, index1, index2 + 1, menus, meals)
        } else {
            throw RuntimeException()
        }
    }

    internal fun validate(dish1: Dish, dish2: Dish, menus: List<DailyMenu>, meals: List<Meal>): Boolean {
        return dish1 != dish2
            &&
            meals.flatMap {
                it.dishes
            }.filter { it == dish1 }.count() == 2
            &&
            meals.flatMap {
                it.dishes
            }.filter { it == dish2 }.count() <= 2
    }
}
