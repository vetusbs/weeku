package io.weeku.domain.usecase.weeklymenu

import io.weeku.data.model.DailyMenu
import io.weeku.data.model.WeeklyMenu
import io.weeku.data.repository.meal.MealRepository
import org.springframework.stereotype.Component

@Component
class CreateWeeklyMenuUseCase(
    private val mealRepository: MealRepository
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
                mealRepository.meal,
                mealRepository.meal
            )
        )
}
