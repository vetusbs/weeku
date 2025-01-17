package io.weeku.domain.service

import io.weeku.domain.model.DailyMenu
import io.weeku.domain.model.TwoDishMeal
import io.weeku.domain.model.WeeklyMenu
import io.weeku.domain.service.csp.Constrain
import org.springframework.stereotype.Component

@Component
class MenuServiceImpl(
    val dishRepository: DishRepository
) : MenuService {

    override fun generateWeeklyMenu(numberOfDays: Int, userContraints: List<Constrain>): WeeklyMenu {
        return WeeklyMenu(
            generateSequence {
                generateDailyMenu()
            }
                .take(numberOfDays)
                .toList()
        )
    }

    private fun generateDailyMenu() =
        DailyMenu(
            listOf(
                TwoDishMeal(
                    dishRepository.fetchRandomDish(),
                    dishRepository.fetchRandomDish()
                ),
                TwoDishMeal(
                    dishRepository.fetchRandomDish(),
                    dishRepository.fetchRandomDish()
                )
            )
        )
}
