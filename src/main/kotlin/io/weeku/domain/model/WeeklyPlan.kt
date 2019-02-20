package io.weeku.domain.model

import io.weeku.data.model.WeeklyMenu

data class WeeklyPlan(val weeklyMenu: WeeklyMenu, val shoppingList: ShoppingList)
