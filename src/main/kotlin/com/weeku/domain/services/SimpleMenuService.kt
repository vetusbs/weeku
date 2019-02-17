package com.weeku.domain.services

import com.weeku.domain.services.objects.DailyMenu
import com.weeku.domain.services.objects.Dish
import com.weeku.domain.services.objects.Meal
import com.weeku.domain.services.objects.WeeklyMenu
import org.springframework.stereotype.Component
import kotlin.random.Random

private val STARTERS = listOf(
        Dish("Macarrons"),
        Dish("Patata i monjeta"),
        Dish("Sopa de peix"),
        Dish("Caldo de verdures"),
        Dish("Amanida verda"),
        Dish("Arròs a la cubana")
)

private val DESERTS = listOf(
        Dish("Flam"),
        Dish("Yougurt"),
        Dish("Poma"),
        Dish("Pera"),
        Dish("Taronja"),
        Dish("Crema")
)

private val MAIN_DISHES = listOf(
        Dish("Entrecot"),
        Dish("Vedella amb bolets"),
        Dish("Rap a la planxa"),
        Dish("Filet de pollastre"),
        Dish("Croquetes"),
        Dish("Cunill")
)

@Component
class SimpleMenuService : MenuService {

    private val random = Random(1)

    override fun generateWeeklyMenu(): WeeklyMenu {
        return WeeklyMenu(
                listOf(
                        generateDailyMenu(),
                        generateDailyMenu(),
                        generateDailyMenu(),
                        generateDailyMenu(),
                        generateDailyMenu(),
                        generateDailyMenu(),
                        generateDailyMenu()
                )
        )
    }

    private fun generateDailyMenu() = DailyMenu(
            listOf(
                    generateMeal(),
                    generateMeal()
            )
    )

    private fun generateMeal() = Meal(
            getRandomDish(STARTERS),
            getRandomDish(MAIN_DISHES),
            getRandomDish(DESERTS)
    )

    private fun getRandomDish(dishes: List<Dish>): Dish {
        return dishes.get(random.nextInt(0, dishes.size))
    }
}