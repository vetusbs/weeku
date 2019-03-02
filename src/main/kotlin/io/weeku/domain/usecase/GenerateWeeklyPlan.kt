package io.weeku.domain.usecase

import io.weeku.domain.model.WeeklyPlan
import io.weeku.domain.service.MenuService
import io.weeku.domain.service.ShoppingListService

@UseCaseComponent
class GenerateWeeklyPlan(
    val menuService: MenuService,
    val shoppingService: ShoppingListService
) : UseCase<GenerateWeeklyPlanInput, GenerateWeeklyPlanOutput> {

    override fun execute(input: GenerateWeeklyPlanInput): GenerateWeeklyPlanOutput {
        if (input.numberOfDays <= 0 || input.numberOfDays > 7) {
            return GenerateWeeklyPlanErrorOutput("Number of days should be greater than 0 and lower than 7")
        }

        val weeklyMenu = menuService.generateWeeklyMenu(input.numberOfDays)
        val shoppingList = shoppingService.extractShoppingList(weeklyMenu)

        return GenerateWeeklyPlanOkOutput(WeeklyPlan(weeklyMenu, shoppingList))
    }
}

data class GenerateWeeklyPlanInput(val numberOfDays: Int)

sealed class GenerateWeeklyPlanOutput
data class GenerateWeeklyPlanOkOutput(val weeklyPlan: WeeklyPlan) : GenerateWeeklyPlanOutput()
data class GenerateWeeklyPlanErrorOutput(val error: String) : GenerateWeeklyPlanOutput()
