package io.weeku.domain.service

import io.weeku.data.model.WeeklyMenu
import io.weeku.domain.model.ShoppingList
import io.weeku.domain.usecase.shoppinglist.ShoppingListUseCase
import io.weeku.domain.usecase.weeklymenu.WeeklyMenuUseCase
import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class MenuServiceImpl(
    private val weeklyMenuUseCase: WeeklyMenuUseCase,
    private val shoppingListUseCase: ShoppingListUseCase
) : MenuService {

    override fun generateWeeklyMenu(): Pair<WeeklyMenu, ShoppingList> {
        val weeklyMenu = weeklyMenuUseCase.generateWeeklyMenu()
        val shoppingList = shoppingListUseCase.extractShoppingList(weeklyMenu)
        return Pair(weeklyMenu, shoppingList)
    }
}
