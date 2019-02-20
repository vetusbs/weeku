package io.weeku.domain.service

import io.weeku.domain.model.WeeklyPlan
import io.weeku.domain.usecase.shoppinglist.ExtractShoppingListUseCase
import io.weeku.domain.usecase.weeklymenu.CreateWeeklyMenuUseCase
import org.springframework.stereotype.Component

@Component
class MenuServiceImpl(
    private val createWeeklyMenuUseCase: CreateWeeklyMenuUseCase,
    private val extractShoppingListUseCase: ExtractShoppingListUseCase
) : MenuService {

    override fun generateWeeklyMenu(): WeeklyPlan {
        val weeklyMenu = createWeeklyMenuUseCase.generateWeeklyMenu()
        val shoppingList = extractShoppingListUseCase.extractShoppingList(weeklyMenu)
        return WeeklyPlan(weeklyMenu, shoppingList)
    }
}
