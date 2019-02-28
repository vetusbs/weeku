package io.weeku.domain.usecase.weeklymenu

import io.weeku.domain.model.DailyMenu
import io.weeku.domain.model.Meal
import io.weeku.domain.model.WeeklyMenu
import io.weeku.domain.service.DishRepository
import org.springframework.stereotype.Component

@Component
class CreateWeeklyMenuUseCase(
    private val dishRepository: DishRepository
) {

    fun generateWeeklyMenu(): WeeklyMenu {
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

    private fun generateDailyMenu() =
        DailyMenu(
            listOf(
                Meal(
                    listOf(
                        dishRepository.fetchRandomDish(),
                        dishRepository.fetchRandomDish()
                    )
                ),
                Meal(
                    listOf(
                        dishRepository.fetchRandomDish(),
                        dishRepository.fetchRandomDish()
                    )
                )
            )
        )
}
