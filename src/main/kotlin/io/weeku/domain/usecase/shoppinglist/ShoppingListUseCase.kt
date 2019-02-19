package io.weeku.domain.usecase.shoppinglist

import io.weeku.data.model.WeeklyMenu
import io.weeku.domain.model.ShoppingList
import org.springframework.stereotype.Component

@Component
interface ShoppingListUseCase {
    fun extractShoppingList(weeklyMenu: WeeklyMenu): ShoppingList
}
