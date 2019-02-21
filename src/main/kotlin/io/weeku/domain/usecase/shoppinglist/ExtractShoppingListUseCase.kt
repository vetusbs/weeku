package io.weeku.domain.usecase.shoppinglist

import io.weeku.domain.model.WeeklyMenu
import io.weeku.domain.model.ShoppingList
import org.springframework.stereotype.Component

@Component
class ExtractShoppingListUseCase {

    fun extractShoppingList(weeklyMenu: WeeklyMenu): ShoppingList {
        return ShoppingList(emptyList()) // TODO @antonio-manuel process weeklymenu
    }
}
