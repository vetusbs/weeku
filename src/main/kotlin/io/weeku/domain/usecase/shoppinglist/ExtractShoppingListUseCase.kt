package io.weeku.domain.usecase.shoppinglist

import io.weeku.domain.model.Ingredient
import io.weeku.domain.model.ShoppingList
import io.weeku.domain.model.WeeklyMenu
import io.weeku.extensions.extractElementEquals
import org.springframework.stereotype.Component

@Component
class ExtractShoppingListUseCase {

    fun extractShoppingList(weeklyMenu: WeeklyMenu): ShoppingList {
        val ingredientList = mutableListOf<Ingredient>()
        weeklyMenu.dailyMenus
            .flatMap { dailyMenu -> dailyMenu.dishes }
            .flatMap { meal -> meal.dishes }
            .flatMap { dish -> dish.ingredients }
            .forEach { ingredient ->
                if (ingredientList.contains(ingredient)) {
                    ingredientList.update(ingredient)
                } else {
                    ingredientList.add(ingredient)
                }
            }
        return ShoppingList(ingredientList)
    }

    private fun MutableList<Ingredient>.update(ingredient: Ingredient) {
        val previousIngredient = extractElementEquals(ingredient)
        val updatedIngredient = previousIngredient.copy(amount = previousIngredient.amount + ingredient.amount)
        add(updatedIngredient)
    }
}
