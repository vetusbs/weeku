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
        val weeklyMenu = menuService.generateWeeklyMenu(input.numberOfDays)
        val shoppingList = shoppingService.extractShoppingList(weeklyMenu)
        return GenerateWeeklyPlanOutput(WeeklyPlan(weeklyMenu, shoppingList))
    }
}

data class GenerateWeeklyPlanInput(val numberOfDays: Int)
data class GenerateWeeklyPlanOutput(val weeklyPlan: WeeklyPlan)
