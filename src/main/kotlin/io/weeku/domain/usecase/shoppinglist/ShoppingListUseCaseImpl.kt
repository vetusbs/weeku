package io.weeku.domain.usecase.shoppinglist

import io.weeku.data.model.WeeklyMenu
import io.weeku.domain.model.ShoppingList
import org.springframework.stereotype.Component

@Component
class ShoppingListUseCaseImpl : ShoppingListUseCase {

    override fun extractShoppingList(weeklyMenu: WeeklyMenu): ShoppingList {
        return ShoppingList(emptyList()) //TODO @antonio-manuel process weeklymenu
    }
}