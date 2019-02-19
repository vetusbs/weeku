package io.weeku.domain.service

import io.weeku.data.model.WeeklyMenu
import io.weeku.domain.model.ShoppingList
import org.springframework.stereotype.Component

@Component
interface MenuService {
    fun generateWeeklyMenu(): Pair<WeeklyMenu, ShoppingList>
}
