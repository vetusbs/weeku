package io.weeku.domain.usecase

import io.weeku.domain.model.Tag
import io.weeku.domain.model.WeeklyPlan
import io.weeku.domain.service.MenuService
import io.weeku.domain.service.ShoppingListService
import io.weeku.domain.service.csp.Constrain
import io.weeku.domain.service.csp.MaxTagPerMenu
import io.weeku.domain.service.csp.MaxTimesPerDishContraint

@UseCaseComponent
class GenerateWeeklyPlan(
    val constraintSatisfactionMenuService: MenuService,
    val shoppingService: ShoppingListService
) : UseCase<GenerateWeeklyPlanInput, GenerateWeeklyPlanOutput> {

    override fun execute(input: GenerateWeeklyPlanInput): GenerateWeeklyPlanOutput {
        if (input.numberOfDays <= 0 || input.numberOfDays > 7) {
            return GenerateWeeklyPlanErrorOutput("Number of days should be greater than 0 and lower than 7")
        }

        val userConstraints = fetchUserConstraints()
        val weeklyMenu = constraintSatisfactionMenuService.generateWeeklyMenu(input.numberOfDays, userConstraints)
        val shoppingList = shoppingService.extractShoppingList(weeklyMenu)

        return GenerateWeeklyPlanOkOutput(WeeklyPlan(weeklyMenu, shoppingList))
    }

    private fun fetchUserConstraints(): List<Constrain> =
        listOf(
            MaxTimesPerDishContraint(5),
            MaxTagPerMenu(2, Tag("pasta"))
        )

}

data class GenerateWeeklyPlanInput(val numberOfDays: Int)

sealed class GenerateWeeklyPlanOutput
data class GenerateWeeklyPlanOkOutput(val weeklyPlan: WeeklyPlan) : GenerateWeeklyPlanOutput()
data class GenerateWeeklyPlanErrorOutput(val error: String) : GenerateWeeklyPlanOutput()
